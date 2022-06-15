var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "6000",
        "ok": "521",
        "ko": "5479"
    },
    "minResponseTime": {
        "total": "50",
        "ok": "1687",
        "ko": "50"
    },
    "maxResponseTime": {
        "total": "5006",
        "ok": "5006",
        "ko": "3206"
    },
    "meanResponseTime": {
        "total": "1129",
        "ok": "3671",
        "ko": "887"
    },
    "standardDeviation": {
        "total": "989",
        "ok": "980",
        "ko": "554"
    },
    "percentiles1": {
        "total": "901",
        "ok": "4208",
        "ko": "630"
    },
    "percentiles2": {
        "total": "1387",
        "ok": "4452",
        "ko": "1307"
    },
    "percentiles3": {
        "total": "3947",
        "ok": "4719",
        "ko": "1677"
    },
    "percentiles4": {
        "total": "4608",
        "ok": "4976",
        "ko": "3035"
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
    "count": 521,
    "percentage": 9
},
    "group4": {
    "name": "failed",
    "count": 5479,
    "percentage": 91
},
    "meanNumberOfRequestsPerSecond": {
        "total": "857.143",
        "ok": "74.429",
        "ko": "782.714"
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
        "total": "3000",
        "ok": "74",
        "ko": "2926"
    },
    "minResponseTime": {
        "total": "50",
        "ok": "3294",
        "ko": "50"
    },
    "maxResponseTime": {
        "total": "4287",
        "ok": "4287",
        "ko": "3206"
    },
    "meanResponseTime": {
        "total": "621",
        "ok": "3829",
        "ko": "540"
    },
    "standardDeviation": {
        "total": "720",
        "ok": "402",
        "ko": "510"
    },
    "percentiles1": {
        "total": "575",
        "ok": "4154",
        "ko": "573"
    },
    "percentiles2": {
        "total": "610",
        "ok": "4194",
        "ko": "606"
    },
    "percentiles3": {
        "total": "2829",
        "ok": "4272",
        "ko": "635"
    },
    "percentiles4": {
        "total": "4164",
        "ok": "4278",
        "ko": "3112"
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
    "count": 74,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "count": 2926,
    "percentage": 98
},
    "meanNumberOfRequestsPerSecond": {
        "total": "428.571",
        "ok": "10.571",
        "ko": "418"
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
        "total": "3000",
        "ok": "447",
        "ko": "2553"
    },
    "minResponseTime": {
        "total": "170",
        "ok": "1687",
        "ko": "170"
    },
    "maxResponseTime": {
        "total": "5006",
        "ok": "5006",
        "ko": "1885"
    },
    "meanResponseTime": {
        "total": "1636",
        "ok": "3645",
        "ko": "1285"
    },
    "standardDeviation": {
        "total": "962",
        "ok": "1043",
        "ko": "256"
    },
    "percentiles1": {
        "total": "1352",
        "ok": "4293",
        "ko": "1305"
    },
    "percentiles2": {
        "total": "1512",
        "ok": "4472",
        "ko": "1455"
    },
    "percentiles3": {
        "total": "4422",
        "ok": "4737",
        "ko": "1754"
    },
    "percentiles4": {
        "total": "4692",
        "ok": "4978",
        "ko": "1838"
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
    "count": 447,
    "percentage": 15
},
    "group4": {
    "name": "failed",
    "count": 2553,
    "percentage": 85
},
    "meanNumberOfRequestsPerSecond": {
        "total": "428.571",
        "ok": "63.857",
        "ko": "364.714"
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
