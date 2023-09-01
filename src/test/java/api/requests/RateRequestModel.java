package api.requests;

import lombok.Data;

@Data
public class RateRequestModel {
    Integer id, rate;
    String session;
}
