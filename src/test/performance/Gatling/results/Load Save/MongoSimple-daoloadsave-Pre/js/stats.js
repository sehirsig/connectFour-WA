var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "34560",
        "ok": "33199",
        "ko": "1361"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "559",
        "ok": "559",
        "ko": "286"
    },
    "meanResponseTime": {
        "total": "10",
        "ok": "4",
        "ko": "164"
    },
    "standardDeviation": {
        "total": "44",
        "ok": "28",
        "ko": "75"
    },
    "percentiles1": {
        "total": "2",
        "ok": "2",
        "ko": "172"
    },
    "percentiles2": {
        "total": "2",
        "ok": "2",
        "ko": "242"
    },
    "percentiles3": {
        "total": "22",
        "ok": "6",
        "ko": "265"
    },
    "percentiles4": {
        "total": "248",
        "ok": "28",
        "ko": "269"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 33199,
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
    "count": 1361,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "79.448",
        "ok": "76.32",
        "ko": "3.129"
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
        "ko": "66"
    },
    "maxResponseTime": {
        "total": "541",
        "ok": "541",
        "ko": "286"
    },
    "meanResponseTime": {
        "total": "15",
        "ok": "5",
        "ko": "207"
    },
    "standardDeviation": {
        "total": "59",
        "ok": "37",
        "ko": "50"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "216"
    },
    "percentiles2": {
        "total": "2",
        "ok": "2",
        "ko": "250"
    },
    "percentiles3": {
        "total": "149",
        "ok": "4",
        "ko": "267"
    },
    "percentiles4": {
        "total": "265",
        "ok": "19",
        "ko": "270"
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
        "total": "39.724",
        "ok": "37.657",
        "ko": "2.067"
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
        "ok": "16818",
        "ko": "462"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "559",
        "ok": "559",
        "ko": "131"
    },
    "meanResponseTime": {
        "total": "6",
        "ok": "4",
        "ko": "79"
    },
    "standardDeviation": {
        "total": "20",
        "ok": "15",
        "ko": "24"
    },
    "percentiles1": {
        "total": "2",
        "ok": "2",
        "ko": "87"
    },
    "percentiles2": {
        "total": "3",
        "ok": "3",
        "ko": "91"
    },
    "percentiles3": {
        "total": "12",
        "ok": "7",
        "ko": "93"
    },
    "percentiles4": {
        "total": "91",
        "ok": "32",
        "ko": "124"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 16818,
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
    "count": 462,
    "percentage": 3
},
    "meanNumberOfRequestsPerSecond": {
        "total": "39.724",
        "ok": "38.662",
        "ko": "1.062"
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
