package com.agys.enums;


    public enum Environments {

        /**
         * Enumerator for testing environments
         *
         * @author aila.bogasieru@agys.ch
         */



        IDENTITY("http://dev01.hq.smartfabric.ch:7000"),
        GUI("http://dev01.hq.smartfabric.ch:9000"),
        DOCUMENTS("http://dev01.hq.smartfabric.ch:9901"),
        CATALOGS("http://dev01.hq.smartfabric.ch:7050"),
        ENGINE("http://dev01.hq.smartfabric.ch:8080");

        private String URL;

        Environments(String URL) {
            this.URL = URL;
        }

        public String getURL() {
            return URL;
        }
    }

