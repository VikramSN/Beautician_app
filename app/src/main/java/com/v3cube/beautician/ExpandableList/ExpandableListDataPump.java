package com.v3cube.beautician.ExpandableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("Classic");
        cricket.add("Nail drill machine");

        List<String> football = new ArrayList<String>();
        football.add("Classic");
        football.add("Nail drill machine");

//        List<String> basketball = new ArrayList<String>();
//        basketball.add("United States");
//        basketball.add("Spain");
//        basketball.add("Argentina");
//        basketball.add("France");
//        basketball.add("Russia");

        expandableListDetail.put("manicure", cricket);
        expandableListDetail.put("pedicute", football);
        return expandableListDetail;
    }
}
