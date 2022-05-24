var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "6000",
        "ok": "1954",
        "ko": "4046"
    },
    "minResponseTime": {
        "total": "23",
        "ok": "23",
        "ko": "86"
    },
    "maxResponseTime": {
        "total": "5355",
        "ok": "5355",
        "ko": "4180"
    },
    "meanResponseTime": {
        "total": "2117",
        "ok": "1906",
        "ko": "2218"
    },
    "standardDeviation": {
        "total": "1042",
        "ok": "1509",
        "ko": "693"
    },
    "percentiles1": {
        "total": "2203",
        "ok": "2479",
        "ko": "2197"
    },
    "percentiles2": {
        "total": "2832",
        "ok": "3278",
        "ko": "2501"
    },
    "percentiles3": {
        "total": "3728",
        "ok": "4084",
        "ko": "3480"
    },
    "percentiles4": {
        "total": "4177",
        "ok": "4647",
        "ko": "3939"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 821,
    "percentage": 14
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 113,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1020,
    "percentage": 17
},
    "group4": {
    "name": "failed",
    "count": 4046,
    "percentage": 67
},
    "meanNumberOfRequestsPerSecond": {
        "total": "857.143",
        "ok": "279.143",
        "ko": "578"
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
        "ok": "613",
        "ko": "2387"
    },
    "minResponseTime": {
        "total": "56",
        "ok": "56",
        "ko": "86"
    },
    "maxResponseTime": {
        "total": "5355",
        "ok": "5355",
        "ko": "2634"
    },
    "meanResponseTime": {
        "total": "1814",
        "ok": "1595",
        "ko": "1870"
    },
    "standardDeviation": {
        "total": "882",
        "ok": "1674",
        "ko": "493"
    },
    "percentiles1": {
        "total": "1958",
        "ok": "408",
        "ko": "1975"
    },
    "percentiles2": {
        "total": "2254",
        "ok": "3214",
        "ko": "2225"
    },
    "percentiles3": {
        "total": "3312",
        "ok": "4608",
        "ko": "2370"
    },
    "percentiles4": {
        "total": "4609",
        "ok": "4713",
        "ko": "2419"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 376,
    "percentage": 13
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 4,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 233,
    "percentage": 8
},
    "group4": {
    "name": "failed",
    "count": 2387,
    "percentage": 80
},
    "meanNumberOfRequestsPerSecond": {
        "total": "428.571",
        "ok": "87.571",
        "ko": "341"
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
        "ok": "1341",
        "ko": "1659"
    },
    "minResponseTime": {
        "total": "23",
        "ok": "23",
        "ko": "1556"
    },
    "maxResponseTime": {
        "total": "5020",
        "ok": "5020",
        "ko": "4180"
    },
    "meanResponseTime": {
        "total": "2419",
        "ok": "2048",
        "ko": "2719"
    },
    "standardDeviation": {
        "total": "1101",
        "ok": "1404",
        "ko": "629"
    },
    "percentiles1": {
        "total": "2717",
        "ok": "2737",
        "ko": "2716"
    },
    "percentiles2": {
        "total": "3201",
        "ok": "3278",
        "ko": "3106"
    },
    "percentiles3": {
        "total": "3858",
        "ok": "3690",
        "ko": "3862"
    },
    "percentiles4": {
        "total": "4136",
        "ok": "4030",
        "ko": "4149"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 445,
    "percentage": 15
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 109,
    "percentage": 4
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 787,
    "percentage": 26
},
    "group4": {
    "name": "failed",
    "count": 1659,
    "percentage": 55
},
    "meanNumberOfRequestsPerSecond": {
        "total": "428.571",
        "ok": "191.571",
        "ko": "237"
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
