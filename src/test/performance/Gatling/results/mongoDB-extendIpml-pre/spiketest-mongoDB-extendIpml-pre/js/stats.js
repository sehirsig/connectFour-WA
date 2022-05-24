var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "60000",
        "ok": "10996",
        "ko": "49004"
    },
    "minResponseTime": {
        "total": "82",
        "ok": "82",
        "ko": "288"
    },
    "maxResponseTime": {
        "total": "25048",
        "ok": "25048",
        "ko": "24383"
    },
    "meanResponseTime": {
        "total": "13206",
        "ok": "11555",
        "ko": "13576"
    },
    "standardDeviation": {
        "total": "6972",
        "ok": "7912",
        "ko": "6687"
    },
    "percentiles1": {
        "total": "15705",
        "ok": "14201",
        "ko": "15953"
    },
    "percentiles2": {
        "total": "19007",
        "ok": "18642",
        "ko": "19063"
    },
    "percentiles3": {
        "total": "21944",
        "ok": "22002",
        "ko": "21906"
    },
    "percentiles4": {
        "total": "23278",
        "ok": "23507",
        "ko": "23232"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 291,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 335,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 10370,
    "percentage": 17
},
    "group4": {
    "name": "failed",
    "count": 49004,
    "percentage": 82
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1578.947",
        "ok": "289.368",
        "ko": "1289.579"
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
        "ok": "3414",
        "ko": "26586"
    },
    "minResponseTime": {
        "total": "288",
        "ok": "782",
        "ko": "288"
    },
    "maxResponseTime": {
        "total": "23997",
        "ok": "23997",
        "ko": "22329"
    },
    "meanResponseTime": {
        "total": "9302",
        "ok": "12109",
        "ko": "8941"
    },
    "standardDeviation": {
        "total": "5684",
        "ok": "5351",
        "ko": "5625"
    },
    "percentiles1": {
        "total": "8801",
        "ok": "12045",
        "ko": "8467"
    },
    "percentiles2": {
        "total": "13953",
        "ok": "16636",
        "ko": "13599"
    },
    "percentiles3": {
        "total": "18899",
        "ok": "20589",
        "ko": "18471"
    },
    "percentiles4": {
        "total": "21492",
        "ok": "22830",
        "ko": "20576"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 14,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3399,
    "percentage": 11
},
    "group4": {
    "name": "failed",
    "count": 26586,
    "percentage": 89
},
    "meanNumberOfRequestsPerSecond": {
        "total": "789.474",
        "ok": "89.842",
        "ko": "699.632"
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
        "ok": "7582",
        "ko": "22418"
    },
    "minResponseTime": {
        "total": "82",
        "ok": "82",
        "ko": "12324"
    },
    "maxResponseTime": {
        "total": "25048",
        "ok": "25048",
        "ko": "24383"
    },
    "meanResponseTime": {
        "total": "17109",
        "ok": "11306",
        "ko": "19072"
    },
    "standardDeviation": {
        "total": "5866",
        "ok": "8814",
        "ko": "2130"
    },
    "percentiles1": {
        "total": "18686",
        "ok": "16088",
        "ko": "19052"
    },
    "percentiles2": {
        "total": "20393",
        "ok": "19343",
        "ko": "20604"
    },
    "percentiles3": {
        "total": "22563",
        "ok": "22407",
        "ko": "22572"
    },
    "percentiles4": {
        "total": "23590",
        "ok": "23731",
        "ko": "23582"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 290,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 321,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 6971,
    "percentage": 23
},
    "group4": {
    "name": "failed",
    "count": 22418,
    "percentage": 75
},
    "meanNumberOfRequestsPerSecond": {
        "total": "789.474",
        "ok": "199.526",
        "ko": "589.947"
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
