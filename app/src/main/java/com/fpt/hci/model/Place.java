package com.fpt.hci.model;

import android.content.Context;

/**
 * Created by megha on 15-03-06.
 */
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
