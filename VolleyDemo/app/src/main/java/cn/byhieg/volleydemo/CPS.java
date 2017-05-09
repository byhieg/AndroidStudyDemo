package cn.byhieg.volleydemo;

import java.util.List;

/**
 * Created by byhieg on 17/5/9.
 * Contact with byhieg@gmail.com
 */

public class CPS {

    /**
     * currentPage : 0
     * totalPage : 0
     * subInfos : [{"id":30,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":31,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":32,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":34,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":35,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":36,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":37,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":38,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":39,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":40,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":41,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":42,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":43,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":44,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":45,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":46,"user":"刘道浩","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":47,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":48,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":49,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":50,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":51,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":52,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":53,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":54,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":55,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":56,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":57,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":58,"user":"石琦峰","source_name":"datasource1","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":59,"user":"石琦峰","source_name":"datasourc01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":60,"user":"石琦峰","source_name":"datasourc01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":61,"user":"石琦峰","source_name":"datasourc01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":62,"user":"石琦峰","source_name":"datasourc02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":63,"user":"石琦峰","source_name":"datasourc01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":64,"user":"石琦峰","source_name":"datasourc02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":65,"user":"石琦峰","source_name":"datasourc02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":66,"user":"石琦峰","source_name":"datasourc02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":67,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":68,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":69,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":70,"user":"石琦峰","source_name":"datasourc20","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":71,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":72,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":73,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":74,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":75,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":76,"user":"石琦峰","source_name":"datasourc20","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":77,"user":"石琦峰","source_name":"datasourc19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":78,"user":"石琦峰","source_name":"datasourc20","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":79,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":82,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":83,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":84,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":85,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":86,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":87,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":88,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":89,"user":"user","source_name":"datasource19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":90,"user":"user","source_name":"datasource20","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":91,"user":"user","source_name":"datasource06","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":92,"user":"user","source_name":"datasource07","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":93,"user":"user","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":94,"user":"user","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":95,"user":"user","source_name":"datasource03","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":96,"user":"user","source_name":"datasource04","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":97,"user":"user","source_name":"datasource05","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":98,"user":"user","source_name":"datasource06","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":99,"user":"user","source_name":"datasource07","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":100,"user":"user","source_name":"datasource08","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":101,"user":"user","source_name":"datasource09","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":102,"user":"user","source_name":"datasource10","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":103,"user":"user","source_name":"datasource11","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":104,"user":"user","source_name":"datasource12","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":105,"user":"user","source_name":"datasource13","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":106,"user":"user","source_name":"datasource14","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":107,"user":"user","source_name":"datasource15","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":108,"user":"user","source_name":"datasource16","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":109,"user":"user","source_name":"datasource17","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":110,"user":"user","source_name":"datasource18","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":111,"user":"user","source_name":"datasource19","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":112,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":113,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":114,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":115,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":116,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":117,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":118,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":119,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":120,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":121,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":122,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":123,"user":"石琦峰","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":124,"user":"石琦峰","source_name":"datasource02","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":125,"user":"user","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":126,"user":"user","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":127,"user":"user","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":128,"user":"user","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"},{"id":129,"user":"user","source_name":"datasource01","sub_condition":"{\"condition\":\"age\",\"opeartion\":\"\\u003e\",\"value\":10}"}]
     * result : 查询成功
     */

    private int currentPage;
    private int totalPage;
    private String result;
    private List<SubInfosBean> subInfos;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<SubInfosBean> getSubInfos() {
        return subInfos;
    }

    public void setSubInfos(List<SubInfosBean> subInfos) {
        this.subInfos = subInfos;
    }

    public static class SubInfosBean {
        /**
         * id : 30
         * user : 刘道浩
         * source_name : datasource1
         * sub_condition : {"condition":"age","opeartion":"\u003e","value":10}
         */

        private int id;
        private String user;
        private String source_name;
        private String sub_condition;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getSource_name() {
            return source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }

        public String getSub_condition() {
            return sub_condition;
        }

        public void setSub_condition(String sub_condition) {
            this.sub_condition = sub_condition;
        }
    }
}
