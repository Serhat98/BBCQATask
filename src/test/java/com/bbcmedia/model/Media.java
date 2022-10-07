
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
public class Media {

    private List<Data> data;

}
