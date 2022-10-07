
package com.bbcmedia.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Data {


    private String type;

    private String id;
    @SerializedName("segment_type")
    @Expose
    private String segmentType;
    @SerializedName("title_list")
    @Expose
    private TitleList titleList;

    private String synopses;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    private Offset offset;

    private List<Uri> uris;


}
