package com.fpt.hci.model;

import android.content.Context;

public class Place {

  public String id;
  public String name;
  public String imageName;
  public boolean isFav;
  public String content;
  public String youtubeLink;

  public int getImageResourceId(Context context) {
    return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
  }
}
