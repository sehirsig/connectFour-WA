var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "144240",
        "ok": "20836",
        "ko": "123404"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "32181",
        "ok": "31933",
        "ko": "32181"
    },
    "meanResponseTime": {
        "total": "10912",
        "ok": "6310",
        "ko": "11689"
    },
    "standardDeviation": {
        "total": "7870",
        "ok": "8233",
        "ko": "7535"
    },
    "percentiles1": {
        "total": "10863",
        "ok": "585",
        "ko": "11428"
    },
    "percentiles2": {
        "total": "16351",
        "ok": "13264",
        "ko": "16925"
    },
    "percentiles3": {
        "total": "24911",
        "ok": "22462",
        "ko": "25081"
    },
    "percentiles4": {
        "total": "28197",
        "ok": "28386",
        "ko": "28182"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 10650,
    "percentage": 7
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 613,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 9573,
    "percentage": 7
},
    "group4": {
    "name": "failed",
    "count": 123404,
    "percentage": 86
},
    "meanNumberOfRequestsPerSecond": {
        "total": "796.906",
        "ok": "115.116",
        "ko": "681.79"
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
        "ok": "8006",
        "ko": "64114"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "31933",
        "ok": "31933",
        "ko": "31826"
    },
    "meanResponseTime": {
        "total": "11241",
        "ok": "7040",
        "ko": "11766"
    },
    "standardDeviation": {
        "total": "8070",
        "ok": "8909",
        "ko": "7802"
    },
    "percentiles1": {
        "total": "11064",
        "ok": "7",
        "ko": "11412"
    },
    "percentiles2": {
        "total": "17571",
        "ok": "14222",
        "ko": "17775"
    },
    "percentiles3": {
        "total": "25071",
        "ok": "23998",
        "ko": "25137"
    },
    "percentiles4": {
        "total": "28188",
        "ok": "28777",
        "ko": "28173"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4462,
    "percentage": 6
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3536,
    "percentage": 5
},
    "group4": {
    "name": "failed",
    "count": 64114,
    "percentage": 89
},
    "meanNumberOfRequestsPerSecond": {
        "total": "398.453",
        "ok": "44.232",
        "ko": "354.221"
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
        "ok": "12830",
        "ko": "59290"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "32181",
        "ok": "31848",
        "ko": "32181"
    },
    "meanResponseTime": {
        "total": "10583",
        "ok": "5854",
        "ko": "11606"
    },
    "standardDeviation": {
        "total": "7651",
        "ok": "7746",
        "ko": "7234"
    },
    "percentiles1": {
        "total": "10703",
        "ok": "979",
        "ko": "11428"
    },
    "percentiles2": {
        "total": "15502",
        "ok": "12536",
        "ko": "16064"
    },
    "percentiles3": {
        "total": "24681",
        "ok": "20491",
        "ko": "24961"
    },
    "percentiles4": {
        "total": "28204",
        "ok": "27974",
        "ko": "28245"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 6188,
    "percentage": 9
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 605,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 6037,
    "percentage": 8
},
    "group4": {
    "name": "failed",
    "count": 59290,
    "percentage": 82
},
    "meanNumberOfRequestsPerSecond": {
        "total": "398.453",
        "ok": "70.884",
        "ko": "327.569"
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
