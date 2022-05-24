var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "34560",
        "ok": "1906",
        "ko": "32654"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "41",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "60016",
        "ok": "59247",
        "ko": "60016"
    },
    "meanResponseTime": {
        "total": "512",
        "ok": "4085",
        "ko": "303"
    },
    "standardDeviation": {
        "total": "3977",
        "ok": "7817",
        "ko": "3519"
    },
    "percentiles1": {
        "total": "3",
        "ok": "1521",
        "ko": "3"
    },
    "percentiles2": {
        "total": "16",
        "ok": "5378",
        "ko": "15"
    },
    "percentiles3": {
        "total": "668",
        "ok": "10576",
        "ko": "378"
    },
    "percentiles4": {
        "total": "7998",
        "ok": "44788",
        "ko": "2662"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 836,
    "percentage": 2
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 82,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 988,
    "percentage": 3
},
    "group4": {
    "name": "failed",
    "count": 32654,
    "percentage": 94
},
    "meanNumberOfRequestsPerSecond": {
        "total": "67.898",
        "ok": "3.745",
        "ko": "64.153"
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
        "ok": "697",
        "ko": "16583"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "420",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "60016",
        "ok": "59247",
        "ko": "60016"
    },
    "meanResponseTime": {
        "total": "698",
        "ok": "4607",
        "ko": "534"
    },
    "standardDeviation": {
        "total": "4891",
        "ok": "4674",
        "ko": "4831"
    },
    "percentiles1": {
        "total": "3",
        "ok": "3701",
        "ko": "3"
    },
    "percentiles2": {
        "total": "19",
        "ok": "6785",
        "ko": "16"
    },
    "percentiles3": {
        "total": "1689",
        "ok": "10040",
        "ko": "403"
    },
    "percentiles4": {
        "total": "11142",
        "ok": "11535",
        "ko": "10211"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 91,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 48,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 558,
    "percentage": 3
},
    "group4": {
    "name": "failed",
    "count": 16583,
    "percentage": 96
},
    "meanNumberOfRequestsPerSecond": {
        "total": "33.949",
        "ok": "1.369",
        "ko": "32.58"
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
        "ok": "1209",
        "ko": "16071"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "41",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "60016",
        "ok": "57538",
        "ko": "60016"
    },
    "meanResponseTime": {
        "total": "325",
        "ok": "3785",
        "ko": "64"
    },
    "standardDeviation": {
        "total": "2763",
        "ok": "9137",
        "ko": "980"
    },
    "percentiles1": {
        "total": "3",
        "ok": "354",
        "ko": "3"
    },
    "percentiles2": {
        "total": "16",
        "ok": "3299",
        "ko": "15"
    },
    "percentiles3": {
        "total": "519",
        "ok": "20863",
        "ko": "326"
    },
    "percentiles4": {
        "total": "6468",
        "ok": "52968",
        "ko": "668"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 745,
    "percentage": 4
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 34,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 430,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "count": 16071,
    "percentage": 93
},
    "meanNumberOfRequestsPerSecond": {
        "total": "33.949",
        "ok": "2.375",
        "ko": "31.574"
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
