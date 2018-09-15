function populateBarChart(ctx, labelArray, dataArray, legend) {
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labelArray,
            datasets: [{
                label: legend,
                data: dataArray,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
}

function populatePieChart(ctx, labelArray, dataArray) {
    var data = {
        datasets: [{
            data: dataArray,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)'
            ]
        }],

        // These labels appear in the legend and in the tooltips when hovering different arcs
        labels: labelArray

    };

    var myDoughnutChart = new Chart(ctx, {
        type: 'pie',
        data: data
    });
}

function populateLineChart(ctx, cmpArray, fda, sda, ftype, stype) {
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: cmpArray,
            datasets: [{
                label: ftype,
                data: fda,
                backgroundColor: "rgba(255, 99, 132, 0.2)"
            }, {
                label: stype,
                data: sda,
                backgroundColor: "rgba(255, 206, 86, 0.2)"
            }]
        }
    });

}