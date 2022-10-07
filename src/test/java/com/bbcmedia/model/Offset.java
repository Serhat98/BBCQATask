
package com.bbcmedia.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offset {

    private Integer start;

    private Integer end;

    private String label;
    @SerializedName("now_playing")
    @Expose
    private Boolean nowPlaying;


}
