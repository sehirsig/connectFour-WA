var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "144240",
        "ok": "36608",
        "ko": "107632"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "50239",
        "ok": "49214",
        "ko": "50239"
    },
    "meanResponseTime": {
        "total": "12175",
        "ok": "2957",
        "ko": "15310"
    },
    "standardDeviation": {
        "total": "11481",
        "ok": "7878",
        "ko": "10807"
    },
    "percentiles1": {
        "total": "8985",
        "ok": "3",
        "ko": "12787"
    },
    "percentiles2": {
        "total": "20410",
        "ok": "8",
        "ko": "23381"
    },
    "percentiles3": {
        "total": "34090",
        "ok": "23728",
        "ko": "35160"
    },
    "percentiles4": {
        "total": "39900",
        "ok": "36432",
        "ko": "40709"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 30035,
    "percentage": 21
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 254,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 6319,
    "percentage": 4
},
    "group4": {
    "name": "failed",
    "count": 107632,
    "percentage": 75
},
    "meanNumberOfRequestsPerSecond": {
        "total": "747.358",
        "ok": "189.679",
        "ko": "557.679"
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
        "ok": "16581",
        "ko": "55539"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "48267",
        "ok": "44566",
        "ko": "48267"
    },
    "meanResponseTime": {
        "total": "13567",
        "ok": "3154",
        "ko": "16676"
    },
    "standardDeviation": {
        "total": "12097",
        "ok": "8786",
        "ko": "11178"
    },
    "percentiles1": {
        "total": "11685",
        "ok": "5",
        "ko": "15806"
    },
    "percentiles2": {
        "total": "23111",
        "ok": "8",
        "ko": "25244"
    },
    "percentiles3": {
        "total": "35107",
        "ok": "28527",
        "ko": "35904"
    },
    "percentiles4": {
        "total": "40383",
        "ok": "37659",
        "ko": "40936"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 14417,
    "percentage": 20
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 2,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2162,
    "percentage": 3
},
    "group4": {
    "name": "failed",
    "count": 55539,
    "percentage": 77
},
    "meanNumberOfRequestsPerSecond": {
        "total": "373.679",
        "ok": "85.912",
        "ko": "287.767"
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
        "ok": "20027",
        "ko": "52093"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "50239",
        "ok": "49214",
        "ko": "50239"
    },
    "meanResponseTime": {
        "total": "10783",
        "ok": "2794",
        "ko": "13855"
    },
    "standardDeviation": {
        "total": "10649",
        "ok": "7035",
        "ko": "10198"
    },
    "percentiles1": {
        "total": "7882",
        "ok": "1",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "16401",
        "ok": "290",
        "ko": "20593"
    },
    "percentiles3": {
        "total": "32776",
        "ok": "18459",
        "ko": "34098"
    },
    "percentiles4": {
        "total": "39642",
        "ok": "34096",
        "ko": "40422"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 15618,
    "percentage": 22
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 252,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 4157,
    "percentage": 6
},
    "group4": {
    "name": "failed",
    "count": 52093,
    "percentage": 72
},
    "meanNumberOfRequestsPerSecond": {
        "total": "373.679",
        "ok": "103.767",
        "ko": "269.912"
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
