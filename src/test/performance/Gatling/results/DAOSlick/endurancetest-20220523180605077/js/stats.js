var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000000",
        "ok": "9898",
        "ko": "1990102"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "41",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "10745",
        "ok": "10745",
        "ko": "9757"
    },
    "meanResponseTime": {
        "total": "127",
        "ok": "2470",
        "ko": "115"
    },
    "standardDeviation": {
        "total": "327",
        "ok": "2533",
        "ko": "219"
    },
    "percentiles1": {
        "total": "66",
        "ok": "1546",
        "ko": "65"
    },
    "percentiles2": {
        "total": "193",
        "ok": "2275",
        "ko": "193"
    },
    "percentiles3": {
        "total": "220",
        "ok": "8551",
        "ko": "218"
    },
    "percentiles4": {
        "total": "1346",
        "ok": "10187",
        "ko": "987"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1794,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1203,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 6901,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1990102,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "711.997",
        "ok": "3.524",
        "ko": "708.473"
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
        "ok": "3291",
        "ko": "996709"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "41",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "10158",
        "ok": "10158",
        "ko": "9757"
    },
    "meanResponseTime": {
        "total": "123",
        "ok": "2380",
        "ko": "115"
    },
    "standardDeviation": {
        "total": "297",
        "ok": "2590",
        "ko": "223"
    },
    "percentiles1": {
        "total": "55",
        "ok": "1305",
        "ko": "56"
    },
    "percentiles2": {
        "total": "192",
        "ok": "2603",
        "ko": "192"
    },
    "percentiles3": {
        "total": "219",
        "ok": "8502",
        "ko": "218"
    },
    "percentiles4": {
        "total": "1137",
        "ok": "9886",
        "ko": "975"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 891,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 533,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1867,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 996709,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "355.999",
        "ok": "1.172",
        "ko": "354.827"
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
        "ok": "6607",
        "ko": "993393"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "55",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "10745",
        "ok": "10745",
        "ko": "8017"
    },
    "meanResponseTime": {
        "total": "131",
        "ok": "2515",
        "ko": "115"
    },
    "standardDeviation": {
        "total": "354",
        "ok": "2503",
        "ko": "215"
    },
    "percentiles1": {
        "total": "69",
        "ok": "1631",
        "ko": "56"
    },
    "percentiles2": {
        "total": "194",
        "ok": "2210",
        "ko": "193"
    },
    "percentiles3": {
        "total": "221",
        "ok": "8669",
        "ko": "218"
    },
    "percentiles4": {
        "total": "1498",
        "ok": "10363",
        "ko": "1008"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 903,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 670,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5034,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "count": 993393,
    "percentage": 99
},
    "meanNumberOfRequestsPerSecond": {
        "total": "355.999",
        "ok": "2.352",
        "ko": "353.646"
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
