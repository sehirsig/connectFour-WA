var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000",
        "ok": "320",
        "ko": "1680"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "51",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "408",
        "ok": "408",
        "ko": "236"
    },
    "meanResponseTime": {
        "total": "43",
        "ok": "144",
        "ko": "23"
    },
    "standardDeviation": {
        "total": "54",
        "ok": "61",
        "ko": "20"
    },
    "percentiles1": {
        "total": "21",
        "ok": "141",
        "ko": "18"
    },
    "percentiles2": {
        "total": "37",
        "ok": "174",
        "ko": "27"
    },
    "percentiles3": {
        "total": "168",
        "ok": "226",
        "ko": "46"
    },
    "percentiles4": {
        "total": "219",
        "ok": "401",
        "ko": "115"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 320,
    "percentage": 16
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1680,
    "percentage": 84
},
    "meanNumberOfRequestsPerSecond": {
        "total": "222.222",
        "ok": "35.556",
        "ko": "186.667"
    }
},
contents: {
"req_create-database-71799": {
        type: "REQUEST",
        name: "create database",
path: "create database",
pathFormatted: "req_create-database-71799",
stats: {
    "name": "create database",
    "numberOfRequests": {
        "total": "1000",
        "ok": "132",
        "ko": "868"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "51",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "388",
        "ok": "388",
        "ko": "201"
    },
    "meanResponseTime": {
        "total": "40",
        "ok": "128",
        "ko": "26"
    },
    "standardDeviation": {
        "total": "46",
        "ok": "56",
        "ko": "24"
    },
    "percentiles1": {
        "total": "22",
        "ok": "127",
        "ko": "19"
    },
    "percentiles2": {
        "total": "38",
        "ok": "153",
        "ko": "31"
    },
    "percentiles3": {
        "total": "146",
        "ok": "193",
        "ko": "69"
    },
    "percentiles4": {
        "total": "186",
        "ok": "348",
        "ko": "139"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 132,
    "percentage": 13
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 868,
    "percentage": 87
},
    "meanNumberOfRequestsPerSecond": {
        "total": "111.111",
        "ok": "14.667",
        "ko": "96.444"
    }
}
    },"req_delete-database-12425": {
        type: "REQUEST",
        name: "delete database",
path: "delete database",
pathFormatted: "req_delete-database-12425",
stats: {
    "name": "delete database",
    "numberOfRequests": {
        "total": "1000",
        "ok": "188",
        "ko": "812"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "64",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "408",
        "ok": "408",
        "ko": "236"
    },
    "meanResponseTime": {
        "total": "46",
        "ok": "155",
        "ko": "20"
    },
    "standardDeviation": {
        "total": "61",
        "ok": "62",
        "ko": "15"
    },
    "percentiles1": {
        "total": "19",
        "ok": "150",
        "ko": "17"
    },
    "percentiles2": {
        "total": "37",
        "ok": "188",
        "ko": "24"
    },
    "percentiles3": {
        "total": "186",
        "ok": "231",
        "ko": "40"
    },
    "percentiles4": {
        "total": "233",
        "ok": "406",
        "ko": "58"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 188,
    "percentage": 19
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 812,
    "percentage": 81
},
    "meanNumberOfRequestsPerSecond": {
        "total": "111.111",
        "ok": "20.889",
        "ko": "90.222"
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
