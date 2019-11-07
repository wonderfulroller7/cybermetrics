package com.nyu.cybermetrics.services;

import com.nyu.cybermetrics.entities.CVEEntity;
import com.nyu.cybermetrics.repositories.CVERepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class JSONService {

    @Autowired
    CVERepository cveRepository;

    public void NVDDataParser(String jsonFile) {

        JSONParser jsonParser = new JSONParser();
        try{
            File resource = new ClassPathResource("data/" + jsonFile).getFile();
            FileReader reader = new FileReader(resource);
            JSONObject root = (JSONObject) jsonParser.parse(reader);
            JSONArray cveItems = (JSONArray) root.get("CVE_Items");
            for (int loop = 0; loop < cveItems.size(); loop++) {
                CVEEntity cveEntity = new CVEEntity();
                JSONObject cveObject = (JSONObject) cveItems.get(loop);
                JSONObject temp = (JSONObject) cveObject.get("cve");
                temp = (JSONObject) temp.get("CVE_data_meta");
                cveEntity.setCveid(temp.get("ID").toString());

                cveEntity.setPublished_date(Timestamp.valueOf(cveObject.get("publishedDate").toString().replace("T"," ").replace("Z",":00")));
                temp = (JSONObject) cveObject.get("impact");
                if (null != temp.get("baseMetricV3")) {
                    temp = (JSONObject) temp.get("baseMetricV3");
                    cveEntity.setV3_exploitability_score(Double.parseDouble(temp.get("exploitabilityScore").toString()));
                    cveEntity.setV3_impact_score(Double.parseDouble(temp.get("impactScore").toString()));
                }
                if (null != temp.get("baseMetricV2")) {
                    temp = (JSONObject) temp.get("baseMetricV2");
                    cveEntity.setV2_exploitability_score(Double.parseDouble(temp.get("exploitabilityScore").toString()));
                    cveEntity.setV2_impact_score(Double.parseDouble(temp.get("impactScore").toString()));
                }
                System.out.println(cveEntity);
                cveRepository.save(cveEntity);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
