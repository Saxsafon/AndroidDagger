package design.alex.starwars.data.model.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Объект ответа в сыром виде от API
 */
public class RawResult {

    @SerializedName("count")
    private Integer mCount;

    @SerializedName("results")
    private List<RawPeople> mResults;

    public Integer getCount() {
        return mCount;
    }

    public List<RawPeople> getResults() {
        return mResults;
    }
}
