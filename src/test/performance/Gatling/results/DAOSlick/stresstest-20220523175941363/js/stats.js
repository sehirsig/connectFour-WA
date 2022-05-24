var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "144240",
        "ok": "758",
        "ko": "143482"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "41",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "44771",
        "ok": "34614",
        "ko": "44771"
    },
    "meanResponseTime": {
        "total": "12996",
        "ok": "18740",
        "ko": "12966"
    },
    "standardDeviation": {
        "total": "8456",
        "ok": "10427",
        "ko": "8434"
    },
    "percentiles1": {
        "total": "13169",
        "ok": "23426",
        "ko": "13142"
    },
    "percentiles2": {
        "total": "19117",
        "ok": "25476",
        "ko": "19049"
    },
    "percentiles3": {
        "total": "26472",
        "ok": "30776",
        "ko": "26420"
    },
    "percentiles4": {
        "total": "31060",
        "ok": "33706",
        "ko": "30957"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 139,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 618,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 143482,
    "percentage": 99
},
    "meanNumberOfRequestsPerSecond": {
        "total": "717.612",
        "ok": "3.771",
        "ko": "713.841"
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
        "total": "72120",
        "ok": "93",
        "ko": "72027"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "41",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "42269",
        "ok": "6381",
        "ko": "42269"
    },
    "meanResponseTime": {
        "total": "12638",
        "ok": "904",
        "ko": "12654"
    },
    "standardDeviation": {
        "total": "8572",
        "ok": "1779",
        "ko": "8567"
    },
    "percentiles1": {
        "total": "12711",
        "ok": "89",
        "ko": "12733"
    },
    "percentiles2": {
        "total": "19047",
        "ok": "428",
        "ko": "19053"
    },
    "percentiles3": {
        "total": "26153",
        "ok": "5400",
        "ko": "26152"
    },
    "percentiles4": {
        "total": "31270",
        "ok": "6114",
        "ko": "31271"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 79,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 14,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 72027,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "358.806",
        "ok": "0.463",
        "ko": "358.343"
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
        "total": "72120",
        "ok": "665",
        "ko": "71455"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "53",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "44771",
        "ok": "34614",
        "ko": "44771"
    },
    "meanResponseTime": {
        "total": "13354",
        "ok": "21234",
        "ko": "13281"
    },
    "standardDeviation": {
        "total": "8322",
        "ok": "8531",
        "ko": "8285"
    },
    "percentiles1": {
        "total": "13521",
        "ok": "23834",
        "ko": "13454"
    },
    "percentiles2": {
        "total": "19164",
        "ok": "25834",
        "ko": "19048"
    },
    "percentiles3": {
        "total": "26746",
        "ok": "31694",
        "ko": "26701"
    },
    "percentiles4": {
        "total": "30817",
        "ok": "34015",
        "ko": "30779"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 60,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 604,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "count": 71455,
    "percentage": 99
},
    "meanNumberOfRequestsPerSecond": {
        "total": "358.806",
        "ok": "3.308",
        "ko": "355.498"
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
