var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "60000",
        "ok": "0",
        "ko": "60000"
    },
    "minResponseTime": {
        "total": "133",
        "ok": "-",
        "ko": "133"
    },
    "maxResponseTime": {
        "total": "52258",
        "ok": "-",
        "ko": "52258"
    },
    "meanResponseTime": {
        "total": "25891",
        "ok": "-",
        "ko": "25891"
    },
    "standardDeviation": {
        "total": "12004",
        "ok": "-",
        "ko": "12004"
    },
    "percentiles1": {
        "total": "30519",
        "ok": "-",
        "ko": "30522"
    },
    "percentiles2": {
        "total": "35759",
        "ok": "-",
        "ko": "35760"
    },
    "percentiles3": {
        "total": "39174",
        "ok": "-",
        "ko": "39174"
    },
    "percentiles4": {
        "total": "44086",
        "ok": "-",
        "ko": "44086"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
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
    "count": 60000,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "810.811",
        "ok": "-",
        "ko": "810.811"
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
        "total": "30000",
        "ok": "0",
        "ko": "30000"
    },
    "minResponseTime": {
        "total": "595",
        "ok": "-",
        "ko": "595"
    },
    "maxResponseTime": {
        "total": "50069",
        "ok": "-",
        "ko": "50069"
    },
    "meanResponseTime": {
        "total": "18568",
        "ok": "-",
        "ko": "18568"
    },
    "standardDeviation": {
        "total": "10498",
        "ok": "-",
        "ko": "10498"
    },
    "percentiles1": {
        "total": "18058",
        "ok": "-",
        "ko": "18105"
    },
    "percentiles2": {
        "total": "26590",
        "ok": "-",
        "ko": "26588"
    },
    "percentiles3": {
        "total": "35631",
        "ok": "-",
        "ko": "35631"
    },
    "percentiles4": {
        "total": "38932",
        "ok": "-",
        "ko": "38932"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
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
    "count": 30000,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "405.405",
        "ok": "-",
        "ko": "405.405"
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
        "total": "30000",
        "ok": "0",
        "ko": "30000"
    },
    "minResponseTime": {
        "total": "133",
        "ok": "-",
        "ko": "133"
    },
    "maxResponseTime": {
        "total": "52258",
        "ok": "-",
        "ko": "52258"
    },
    "meanResponseTime": {
        "total": "33215",
        "ok": "-",
        "ko": "33215"
    },
    "standardDeviation": {
        "total": "8410",
        "ok": "-",
        "ko": "8410"
    },
    "percentiles1": {
        "total": "35148",
        "ok": "-",
        "ko": "35143"
    },
    "percentiles2": {
        "total": "37577",
        "ok": "-",
        "ko": "37577"
    },
    "percentiles3": {
        "total": "40093",
        "ok": "-",
        "ko": "40093"
    },
    "percentiles4": {
        "total": "46683",
        "ok": "-",
        "ko": "46683"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
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
    "count": 30000,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "405.405",
        "ok": "-",
        "ko": "405.405"
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
