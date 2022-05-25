var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "34560",
        "ok": "32908",
        "ko": "1652"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "692",
        "ok": "692",
        "ko": "320"
    },
    "meanResponseTime": {
        "total": "28",
        "ok": "21",
        "ko": "159"
    },
    "standardDeviation": {
        "total": "56",
        "ok": "45",
        "ko": "87"
    },
    "percentiles1": {
        "total": "24",
        "ok": "23",
        "ko": "159"
    },
    "percentiles2": {
        "total": "30",
        "ok": "29",
        "ko": "247"
    },
    "percentiles3": {
        "total": "76",
        "ok": "47",
        "ko": "280"
    },
    "percentiles4": {
        "total": "273",
        "ok": "100",
        "ko": "292"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 32908,
    "percentage": 95
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
    "count": 1652,
    "percentage": 5
},
    "meanNumberOfRequestsPerSecond": {
        "total": "79.085",
        "ok": "75.304",
        "ko": "3.78"
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
        "ok": "16380",
        "ko": "900"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "571",
        "ok": "571",
        "ko": "320"
    },
    "meanResponseTime": {
        "total": "16",
        "ok": "5",
        "ko": "229"
    },
    "standardDeviation": {
        "total": "63",
        "ok": "39",
        "ko": "42"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "242"
    },
    "percentiles2": {
        "total": "2",
        "ok": "2",
        "ko": "262"
    },
    "percentiles3": {
        "total": "174",
        "ok": "2",
        "ko": "283"
    },
    "percentiles4": {
        "total": "281",
        "ok": "13",
        "ko": "296"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 16380,
    "percentage": 95
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
    "count": 900,
    "percentage": 5
},
    "meanNumberOfRequestsPerSecond": {
        "total": "39.542",
        "ok": "37.483",
        "ko": "2.059"
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
        "ok": "16528",
        "ko": "752"
    },
    "minResponseTime": {
        "total": "4",
        "ok": "20",
        "ko": "4"
    },
    "maxResponseTime": {
        "total": "692",
        "ok": "692",
        "ko": "130"
    },
    "meanResponseTime": {
        "total": "39",
        "ok": "37",
        "ko": "75"
    },
    "standardDeviation": {
        "total": "45",
        "ok": "44",
        "ko": "40"
    },
    "percentiles1": {
        "total": "29",
        "ok": "29",
        "ko": "94"
    },
    "percentiles2": {
        "total": "41",
        "ok": "40",
        "ko": "106"
    },
    "percentiles3": {
        "total": "59",
        "ok": "54",
        "ko": "114"
    },
    "percentiles4": {
        "total": "130",
        "ok": "153",
        "ko": "129"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 16528,
    "percentage": 96
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
    "count": 752,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "39.542",
        "ok": "37.822",
        "ko": "1.721"
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
