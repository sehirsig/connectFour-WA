var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "34560",
        "ok": "33090",
        "ko": "1470"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "19"
    },
    "maxResponseTime": {
        "total": "490",
        "ok": "490",
        "ko": "249"
    },
    "meanResponseTime": {
        "total": "10",
        "ok": "4",
        "ko": "163"
    },
    "standardDeviation": {
        "total": "44",
        "ok": "28",
        "ko": "61"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "177"
    },
    "percentiles2": {
        "total": "2",
        "ok": "1",
        "ko": "225"
    },
    "percentiles3": {
        "total": "19",
        "ok": "2",
        "ko": "242"
    },
    "percentiles4": {
        "total": "238",
        "ok": "12",
        "ko": "246"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 33090,
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
    "count": 1470,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "79.266",
        "ok": "75.894",
        "ko": "3.372"
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
        "ok": "16389",
        "ko": "891"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "79"
    },
    "maxResponseTime": {
        "total": "490",
        "ok": "490",
        "ko": "249"
    },
    "meanResponseTime": {
        "total": "14",
        "ok": "4",
        "ko": "205"
    },
    "standardDeviation": {
        "total": "57",
        "ok": "35",
        "ko": "40"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "219"
    },
    "percentiles2": {
        "total": "1",
        "ok": "1",
        "ko": "236"
    },
    "percentiles3": {
        "total": "167",
        "ok": "2",
        "ko": "244"
    },
    "percentiles4": {
        "total": "243",
        "ok": "11",
        "ko": "246"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 16389,
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
    "count": 891,
    "percentage": 5
},
    "meanNumberOfRequestsPerSecond": {
        "total": "39.633",
        "ok": "37.589",
        "ko": "2.044"
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
        "ok": "16701",
        "ko": "579"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "19"
    },
    "maxResponseTime": {
        "total": "286",
        "ok": "286",
        "ko": "116"
    },
    "meanResponseTime": {
        "total": "6",
        "ok": "3",
        "ko": "99"
    },
    "standardDeviation": {
        "total": "26",
        "ok": "19",
        "ko": "16"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "107"
    },
    "percentiles2": {
        "total": "2",
        "ok": "2",
        "ko": "109"
    },
    "percentiles3": {
        "total": "8",
        "ok": "3",
        "ko": "114"
    },
    "percentiles4": {
        "total": "112",
        "ok": "14",
        "ko": "115"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 16701,
    "percentage": 97
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
    "count": 579,
    "percentage": 3
},
    "meanNumberOfRequestsPerSecond": {
        "total": "39.633",
        "ok": "38.305",
        "ko": "1.328"
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
