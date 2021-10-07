Morris.Area({
    element: 'morris-area-chart2',
    data: [{
        period: '2010',
        SiteA: 0,
        SiteB: 0,

    }, {
        period: '2011',
        SiteA: 330,
        SiteB: 250,

    }, {
        period: '2012',
        SiteA: 200,
        SiteB: 100,

    }, {
        period: '2013',
        SiteA: 282,
        SiteB: 220,

    }, {
        period: '2014',
        SiteA: 380,
        SiteB: 450,

    }, {
        period: '2015',
        SiteA: 305,
        SiteB: 200,

    }, {
        period: '2016',
        SiteA: 252,
        SiteB: 380,

    }],
    xkey: 'period',
    ykeys: ['SiteA', 'SiteB'],
    labels: ['New clients', 'Returning clients'],
    pointSize: 1,
    fillOpacity: 0.7,
    pointStrokeColors: ['#ccc', '#cbb2ae'],
    behaveLikeLine: true,
    gridLineColor: '#e0e0e0',
    lineWidth: 0,
    smooth: false,
    hideHover: 'auto',
    lineColors: ['#ccc', '#cbb2ae'],
    resize: true

});

$(".counter").counterUp({
    delay: 100,
    time: 1200
});
