var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "20000",
        "ok": "517",
        "ko": "19483"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "116",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "8491",
        "ok": "8491",
        "ko": "7825"
    },
    "meanResponseTime": {
        "total": "279",
        "ok": "2033",
        "ko": "232"
    },
    "standardDeviation": {
        "total": "610",
        "ok": "2316",
        "ko": "394"
    },
    "percentiles1": {
        "total": "191",
        "ok": "1031",
        "ko": "189"
    },
    "percentiles2": {
        "total": "258",
        "ok": "1906",
        "ko": "252"
    },
    "percentiles3": {
        "total": "519",
        "ok": "7545",
        "ko": "374"
    },
    "percentiles4": {
        "total": "2223",
        "ok": "7958",
        "ko": "1094"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 183,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 122,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 212,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "count": 19483,
    "percentage": 97
},
    "meanNumberOfRequestsPerSecond": {
        "total": "344.828",
        "ok": "8.914",
        "ko": "335.914"
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
        "total": "10000",
        "ok": "204",
        "ko": "9796"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "116",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "7935",
        "ok": "7935",
        "ko": "7825"
    },
    "meanResponseTime": {
        "total": "290",
        "ok": "1866",
        "ko": "257"
    },
    "standardDeviation": {
        "total": "650",
        "ok": "2195",
        "ko": "528"
    },
    "percentiles1": {
        "total": "191",
        "ok": "886",
        "ko": "189"
    },
    "percentiles2": {
        "total": "257",
        "ok": "1855",
        "ko": "252"
    },
    "percentiles3": {
        "total": "576",
        "ok": "7313",
        "ko": "401"
    },
    "percentiles4": {
        "total": "3017",
        "ok": "7764",
        "ko": "1669"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 91,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 38,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 75,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "count": 9796,
    "percentage": 98
},
    "meanNumberOfRequestsPerSecond": {
        "total": "172.414",
        "ok": "3.517",
        "ko": "168.897"
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
        "total": "10000",
        "ok": "313",
        "ko": "9687"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "181",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "8491",
        "ok": "8491",
        "ko": "7745"
    },
    "meanResponseTime": {
        "total": "267",
        "ok": "2142",
        "ko": "207"
    },
    "standardDeviation": {
        "total": "566",
        "ok": "2386",
        "ko": "171"
    },
    "percentiles1": {
        "total": "191",
        "ok": "1103",
        "ko": "188"
    },
    "percentiles2": {
        "total": "258",
        "ok": "1974",
        "ko": "251"
    },
    "percentiles3": {
        "total": "464",
        "ok": "7677",
        "ko": "360"
    },
    "percentiles4": {
        "total": "1717",
        "ok": "8142",
        "ko": "789"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 92,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 84,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 137,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "count": 9687,
    "percentage": 97
},
    "meanNumberOfRequestsPerSecond": {
        "total": "172.414",
        "ok": "5.397",
        "ko": "167.017"
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
