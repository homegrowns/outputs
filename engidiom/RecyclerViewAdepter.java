package com.example.engidiom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.engidiom.DB.YoutubeContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class RecyclerViewAdepter extends RecyclerView.Adapter<RecyclerViewAdepter.CustomViewHolder> {

    ArrayList<YoutubeContent> youtubeContentlist;
    YoutubeContent youtubeContent;
    Context context;
    public int ItemPosition;
    SharedPreferences sharedPreferences;

    public RecyclerViewAdepter(ArrayList<YoutubeContent> youtubeContentlist, Context context) {
        this.youtubeContentlist = youtubeContentlist;
        this.context = context;
    }



    @NotNull
    @Override
    public RecyclerViewAdepter.CustomViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.on_line_youvideo, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);


        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        YoutubeContent data = youtubeContentlist.get(holder.getAdapterPosition());
        holder.youtitle.setText(youtubeContentlist.get(position).getTitle());
        holder.youSubtitle.setText(youtubeContentlist.get(position).getSubTitle());
        holder.dateOfPost.setText(String.valueOf(youtubeContentlist.get(position).getDateOfPost()));
        Uri vuri = Uri.parse(youtubeContentlist.get(position).getVideoURL());
        Glide.with(this.context).load(youtubeContentlist.get(position).getImageVideoURL()).thumbnail(0.1f).error(R.drawable.non_image).into(holder.youtubeimage);



        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // editOne 엑티비티에 보내기
                Intent intent = new Intent(context, add_edit_oneActivity.class);
                intent.putExtra("videoUrl", youtubeContentlist.get(position).getVideoURL());
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                Toast.makeText(v.getContext(), position + " 번째 Edit!", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);


            }
        });



        holder.btn_youvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, frag_youtubeActivity.class);
                intent.putExtra("VdURL", youtubeContentlist.get(position).getVideoURL());// idURL to frag_youtube
                Toast.makeText(v.getContext(), position + " 번째 동영상!", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });





        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ItemPosition = holder.getAbsoluteAdapterPosition();
                String st[] = {"1.취소", "2.삭제"};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("선택");
                builder.setItems(st, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (i==0){
                            Toast.makeText(v.getContext(),position+" 삭제 취소", Toast.LENGTH_SHORT).show();
                        }

                        if (i==1) {


                            youtubeContentlist.remove(ItemPosition);
                            notifyItemRemoved(ItemPosition);
                            notifyItemRangeChanged(ItemPosition, youtubeContentlist.size());

                            UpdataAndSaveData(ItemPosition);
                            Toast.makeText(v.getContext(),position+" 삭제", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

                return false;
            }



        });

    }


    @Override
    public int getItemCount() {
            return (null != youtubeContentlist ?  youtubeContentlist.size() : 0);
    }


    private void UpdataAndSaveData(int ItemPosition) {
        sharedPreferences = context.getSharedPreferences("SHAREDPRE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(youtubeContentlist);
        editor.putString("List", json);
        editor.commit();}
/*
    private final MenuItem.OnMenuItemClickListener onEditmenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case 100:
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("제거");
                    AlertDialog alertDialog = builder.create();
                    youtubeContentlist.remove(ItemPosition);
                    notifyItemRemoved(ItemPosition);
                    notifyItemRangeChanged(ItemPosition, youtubeContentlist.size());

                    alertDialog.show();


            }
            return true ;
        }
    };*/




    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView youtubeimage;
        TextView youtitle;
        TextView youSubtitle;
        TextView dateOfPost;
        LinearLayout parentLayout;
        Button btn_youvideo;


        public CustomViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);


            btn_youvideo = itemView.findViewById(R.id.videobutton1);
            youtubeimage = itemView.findViewById(R.id.youtubeimage);
            youtitle = itemView.findViewById(R.id.youtitle);
            youSubtitle = itemView.findViewById(R.id.youSubtitle);
            dateOfPost = itemView.findViewById(R.id.t_dateOfPost);
            parentLayout = itemView.findViewById(R.id.oneLineYoutubeLayout);


        }
    }

}
