var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000000",
        "ok": "78144",
        "ko": "1921856"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "60019",
        "ok": "59895",
        "ko": "60019"
    },
    "meanResponseTime": {
        "total": "18",
        "ok": "121",
        "ko": "14"
    },
    "standardDeviation": {
        "total": "854",
        "ok": "1707",
        "ko": "800"
    },
    "percentiles1": {
        "total": "2",
        "ok": "6",
        "ko": "2"
    },
    "percentiles2": {
        "total": "5",
        "ok": "9",
        "ko": "5"
    },
    "percentiles3": {
        "total": "9",
        "ok": "82",
        "ko": "9"
    },
    "percentiles4": {
        "total": "21",
        "ok": "2822",
        "ko": "18"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 77150,
    "percentage": 4
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 994,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1921856,
    "percentage": 96
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2412.545",
        "ok": "94.263",
        "ko": "2318.282"
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
        "total": "1000000",
        "ok": "39095",
        "ko": "960905"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "60019",
        "ok": "59858",
        "ko": "60019"
    },
    "meanResponseTime": {
        "total": "18",
        "ok": "115",
        "ko": "14"
    },
    "standardDeviation": {
        "total": "845",
        "ok": "1647",
        "ko": "796"
    },
    "percentiles1": {
        "total": "2",
        "ok": "6",
        "ko": "2"
    },
    "percentiles2": {
        "total": "5",
        "ok": "9",
        "ko": "5"
    },
    "percentiles3": {
        "total": "9",
        "ok": "85",
        "ko": "9"
    },
    "percentiles4": {
        "total": "21",
        "ok": "2816",
        "ko": "18"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 38608,
    "percentage": 4
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 487,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 960905,
    "percentage": 96
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1206.273",
        "ok": "47.159",
        "ko": "1159.113"
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
        "total": "1000000",
        "ok": "39049",
        "ko": "960951"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "60016",
        "ok": "59895",
        "ko": "60016"
    },
    "meanResponseTime": {
        "total": "18",
        "ok": "128",
        "ko": "14"
    },
    "standardDeviation": {
        "total": "863",
        "ok": "1765",
        "ko": "805"
    },
    "percentiles1": {
        "total": "2",
        "ok": "6",
        "ko": "2"
    },
    "percentiles2": {
        "total": "5",
        "ok": "9",
        "ko": "5"
    },
    "percentiles3": {
        "total": "9",
        "ok": "79",
        "ko": "9"
    },
    "percentiles4": {
        "total": "21",
        "ok": "2828",
        "ko": "18"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 38542,
    "percentage": 4
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 507,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 960951,
    "percentage": 96
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1206.273",
        "ok": "47.104",
        "ko": "1159.169"
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
