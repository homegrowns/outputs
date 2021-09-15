package com.example.engidiom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.engidiom.DB.IdiomCard;
import com.example.engidiom.DB.ItemTouchHelperListener;
import com.example.engidiom.DB.YoutubeContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class YouMainAdapter extends RecyclerView.Adapter<YouMainAdapter.CustomViewHolder> implements ItemTouchHelperListener {
    ArrayList<IdiomCard> IdiomList ;
    Context context;
    public int ItemPosition;
    SharedPreferences sharedPreferences, sp;


    public YouMainAdapter(ArrayList<IdiomCard> IdiomList, Context context) {
        this.IdiomList = IdiomList;
        this.context = context;

    }

    @Override
    public YouMainAdapter.CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

       return holder;
    }

    @Override
    public void onBindViewHolder( YouMainAdapter.CustomViewHolder holder, int position) {

        holder.youtubetitle.setText(IdiomList.get(position).getArrr());
        holder.youtubeSubtitle.setText(IdiomList.get(position).getsDescription());
        Uri vuri = Uri.parse(IdiomList.get(position).getUrls());
        holder.image_study.setImageResource(IdiomList.get(position).getImage());
     holder.itemView.setTag(position);
     holder.itemView.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
             String curName = holder.youtubetitle.getText().toString();
             Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();

             /*Intent intentf = new Intent(context, dictionary.class );*/
             Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(vuri)));
             Toast.makeText(v.getContext(), position+" 번째 숙어 사전검색!", Toast.LENGTH_SHORT).show();
             context.startActivity(intent);
         }
     });

     holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View v) {
             ItemPosition = holder.getAbsoluteAdapterPosition();
             IdiomList.remove(ItemPosition);
             notifyItemRemoved(ItemPosition);
             notifyItemRangeChanged(ItemPosition, IdiomList.size());

             UpdataAndSaveData(ItemPosition);
            Toast.makeText(v.getContext(),position+" 삭제", Toast.LENGTH_SHORT).show();
             return true;
         }
     });




    }

    @Override
    public int getItemCount() {
        return (null != IdiomList?  IdiomList.size() : 0);
    }

   /* public void remove(int position) {
        try{
            IdiomList.remove(position);
            notifyItemRemoved(position);

        } catch (IndexOutOfBoundsException ex) { // exception 공부해보기
            ex.printStackTrace();
        }
    }
*/
    private void UpdataAndSaveData(int ItemPosition) {
        sp = context.getSharedPreferences("login", MODE_PRIVATE);

        String id = sp.getString("ID", " ");

        sharedPreferences = context.getSharedPreferences("StudySharedCard", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(IdiomList);
        editor.putString(id, json);
        editor.commit();}

    @Override
    public boolean onItemMove(int from_position, int to_position) {
        return false;
    }

    @Override
    public void onItemSwipe(int position) {

    }

    @Override
    public void onLeftClick(int position, RecyclerView.ViewHolder viewHolder) {

    }

    @Override
    public void onRightClick(int position, RecyclerView.ViewHolder viewHolder) {

    }



    public class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView image_study;
        TextView youtubetitle;
        TextView youtubeSubtitle;

        public CustomViewHolder( View itemView) {
            super(itemView);

            image_study = itemView.findViewById(R.id.image_study);
            youtubetitle = itemView.findViewById(R.id.note_title);
            youtubeSubtitle =  itemView.findViewById(R.id.note_Subtitle);
        }
    }
}
