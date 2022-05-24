var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "34560",
        "ok": "32909",
        "ko": "1651"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "12"
    },
    "maxResponseTime": {
        "total": "707",
        "ok": "707",
        "ko": "323"
    },
    "meanResponseTime": {
        "total": "28",
        "ok": "21",
        "ko": "176"
    },
    "standardDeviation": {
        "total": "58",
        "ok": "46",
        "ko": "78"
    },
    "percentiles1": {
        "total": "24",
        "ok": "23",
        "ko": "167"
    },
    "percentiles2": {
        "total": "29",
        "ok": "28",
        "ko": "246"
    },
    "percentiles3": {
        "total": "107",
        "ok": "46",
        "ko": "283"
    },
    "percentiles4": {
        "total": "281",
        "ok": "86",
        "ko": "289"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 32909,
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
    "count": 1651,
    "percentage": 5
},
    "meanNumberOfRequestsPerSecond": {
        "total": "79.266",
        "ok": "75.479",
        "ko": "3.787"
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
        "ok": "16381",
        "ko": "899"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "139"
    },
    "maxResponseTime": {
        "total": "562",
        "ok": "562",
        "ko": "323"
    },
    "meanResponseTime": {
        "total": "17",
        "ok": "5",
        "ko": "237"
    },
    "standardDeviation": {
        "total": "64",
        "ok": "37",
        "ko": "41"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "241"
    },
    "percentiles2": {
        "total": "2",
        "ok": "2",
        "ko": "273"
    },
    "percentiles3": {
        "total": "187",
        "ok": "2",
        "ko": "285"
    },
    "percentiles4": {
        "total": "284",
        "ok": "11",
        "ko": "322"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 16381,
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
    "count": 899,
    "percentage": 5
},
    "meanNumberOfRequestsPerSecond": {
        "total": "39.633",
        "ok": "37.571",
        "ko": "2.062"
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
        "total": "12",
        "ok": "21",
        "ko": "12"
    },
    "maxResponseTime": {
        "total": "707",
        "ok": "707",
        "ko": "225"
    },
    "meanResponseTime": {
        "total": "40",
        "ok": "37",
        "ko": "103"
    },
    "standardDeviation": {
        "total": "49",
        "ok": "48",
        "ko": "41"
    },
    "percentiles1": {
        "total": "29",
        "ok": "28",
        "ko": "121"
    },
    "percentiles2": {
        "total": "41",
        "ok": "40",
        "ko": "128"
    },
    "percentiles3": {
        "total": "63",
        "ok": "49",
        "ko": "135"
    },
    "percentiles4": {
        "total": "139",
        "ok": "135",
        "ko": "224"
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
        "total": "39.633",
        "ok": "37.908",
        "ko": "1.725"
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
