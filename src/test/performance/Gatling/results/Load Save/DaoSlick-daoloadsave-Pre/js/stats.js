var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "34560",
        "ok": "2471",
        "ko": "32089"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "46",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "50260",
        "ok": "50260",
        "ko": "43328"
    },
    "meanResponseTime": {
        "total": "784",
        "ok": "4897",
        "ko": "467"
    },
    "standardDeviation": {
        "total": "3564",
        "ok": "7151",
        "ko": "2887"
    },
    "percentiles1": {
        "total": "2",
        "ok": "1770",
        "ko": "2"
    },
    "percentiles2": {
        "total": "16",
        "ok": "6841",
        "ko": "15"
    },
    "percentiles3": {
        "total": "3637",
        "ok": "20022",
        "ko": "787"
    },
    "percentiles4": {
        "total": "20012",
        "ok": "31143",
        "ko": "17220"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 907,
    "percentage": 3
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 219,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1345,
    "percentage": 4
},
    "group4": {
    "name": "failed",
    "count": 32089,
    "percentage": 93
},
    "meanNumberOfRequestsPerSecond": {
        "total": "71.701",
        "ok": "5.127",
        "ko": "66.575"
    }
},
contents: {
"req_save-grid-1e676": {
        type: "REQUEST",
        name: "save grid",
path: "save grid",
pathFormatted: "req_save-grid-1e676",
stats: {
    "name": "save grid",
    "numberOfRequests": {
        "total": "17280",
        "ok": "522",
        "ko": "16758"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "442",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "50260",
        "ok": "50260",
        "ko": "43328"
    },
    "meanResponseTime": {
        "total": "999",
        "ok": "6380",
        "ko": "832"
    },
    "standardDeviation": {
        "total": "4187",
        "ok": "7677",
        "ko": "3913"
    },
    "percentiles1": {
        "total": "2",
        "ok": "4167",
        "ko": "2"
    },
    "percentiles2": {
        "total": "15",
        "ok": "7625",
        "ko": "15"
    },
    "percentiles3": {
        "total": "5589",
        "ok": "29629",
        "ko": "3160"
    },
    "percentiles4": {
        "total": "23466",
        "ok": "38782",
        "ko": "21928"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 14,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 19,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 489,
    "percentage": 3
},
    "group4": {
    "name": "failed",
    "count": 16758,
    "percentage": 97
},
    "meanNumberOfRequestsPerSecond": {
        "total": "35.851",
        "ok": "1.083",
        "ko": "34.768"
    }
}
    },"req_load-grid-320aa": {
        type: "REQUEST",
        name: "load grid",
path: "load grid",
pathFormatted: "req_load-grid-320aa",
stats: {
    "name": "load grid",
    "numberOfRequests": {
        "total": "17280",
        "ok": "1949",
        "ko": "15331"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "46",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "32754",
        "ok": "32754",
        "ko": "20010"
    },
    "meanResponseTime": {
        "total": "568",
        "ok": "4500",
        "ko": "69"
    },
    "standardDeviation": {
        "total": "2789",
        "ok": "6950",
        "ko": "640"
    },
    "percentiles1": {
        "total": "2",
        "ok": "1000",
        "ko": "2"
    },
    "percentiles2": {
        "total": "16",
        "ok": "5794",
        "ko": "9"
    },
    "percentiles3": {
        "total": "1997",
        "ok": "19485",
        "ko": "258"
    },
    "percentiles4": {
        "total": "15110",
        "ok": "30087",
        "ko": "689"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 893,
    "percentage": 5
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 200,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 856,
    "percentage": 5
},
    "group4": {
    "name": "failed",
    "count": 15331,
    "percentage": 89
},
    "meanNumberOfRequestsPerSecond": {
        "total": "35.851",
        "ok": "4.044",
        "ko": "31.807"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
