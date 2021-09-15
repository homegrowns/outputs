package com.example.engidiom.DB;

import android.provider.BaseColumns;

public class Memo { //SQL 데이터베이스
    private Memo() {

    }
public static class MemoEntry implements BaseColumns {
        public  static final String TABLE_NAME = "Memo";
        public  static final String COLUMN_NAME = "title";
        public  static final String COLUMN_NAME_CONTENTS = "contents";
}

}
