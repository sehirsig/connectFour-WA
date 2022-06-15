var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "200",
        "ok": "200",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1383",
        "ok": "1383",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2105",
        "ok": "2105",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1662",
        "ok": "1662",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "191",
        "ok": "191",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1622",
        "ok": "1622",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1781",
        "ok": "1781",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2012",
        "ok": "2012",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2074",
        "ok": "2074",
        "ko": "-"
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
    "count": 200,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "33.333",
        "ok": "33.333",
        "ko": "-"
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
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1624",
        "ok": "1624",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2105",
        "ok": "2105",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1820",
        "ok": "1820",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "134",
        "ok": "134",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1782",
        "ok": "1782",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1935",
        "ok": "1935",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2043",
        "ok": "2043",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2088",
        "ok": "2088",
        "ko": "-"
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
    "count": 100,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "16.667",
        "ok": "16.667",
        "ko": "-"
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
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1383",
        "ok": "1383",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1620",
        "ok": "1620",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1504",
        "ok": "1504",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "70",
        "ok": "70",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1504",
        "ok": "1504",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1567",
        "ok": "1567",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1611",
        "ok": "1611",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1618",
        "ok": "1618",
        "ko": "-"
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
    "count": 100,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "16.667",
        "ok": "16.667",
        "ko": "-"
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
