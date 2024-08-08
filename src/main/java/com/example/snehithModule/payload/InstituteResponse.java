package com.example.snehithModule.payload;

import java.util.List;

public class InstituteResponse {

    private List<InstituteDTO> snehith;

    public InstituteResponse() {
    }

    public InstituteResponse(List<InstituteDTO> snehith) {
        this.snehith = snehith;
    }

    public List<InstituteDTO> getSnehith() {
        return snehith;
    }

    public void setSnehith(List<InstituteDTO> snehith) {
        this.snehith = snehith;
    }
}
