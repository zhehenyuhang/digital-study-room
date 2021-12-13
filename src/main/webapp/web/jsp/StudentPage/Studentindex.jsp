<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #container {
            min-width: 320px;
            max-width: 800px;
            margin: 0 auto;
        }
    </style>
    <script src="../../js/Student/exporting.js"></script>
    <script src="../../js/Student/highcharts.js"></script>
    <script src="../../js/Student/networkgraph.js"></script>
    <script src="../../js/Student/oldie.js"></script>

</head>
<body>
<jsp:include page="headStudent.jsp"></jsp:include>
<div id="container"></div>
</body>
</html>
<script>
    Highcharts.addEvent(
        Highcharts.seriesTypes.networkgraph,
        'afterSetOptions',
        function (e) {
            var colors = Highcharts.getOptions().colors,
                i = 0,
                nodes = {};
            e.options.data.forEach(function (link) {
                if (link[0] === 'Proto Indo-European') {
                    nodes['Proto Indo-European'] = {
                        id: 'Proto Indo-European',
                        marker: {
                            radius: 20
                        }
                    };
                    nodes[link[1]] = {
                        id: link[1],
                        marker: {
                            radius: 10
                        },
                        color: colors[i++]
                    };
                } else if (nodes[link[0]] && nodes[link[0]].color) {
                    nodes[link[1]] = {
                        id: link[1],
                        color: nodes[link[0]].color
                    };
                }
            });
            e.options.nodes = Object.keys(nodes).map(function (id) {
                return nodes[id];
            });
        }
    );
    Highcharts.chart('container', {
        chart: {
            type: 'networkgraph',
            height: '100%'
        },
        plotOptions: {
            networkgraph: {
                keys: ['from', 'to'],
                layoutAlgorithm: {
                    enableSimulation: true
                }
            }
        },
        series: [{
            dataLabels: {
                enabled: true
            },
            data: [
                ['渭南师范学院', '计算机学院'],
                ['计算机学院', '5213'],
                ['5213', '剩余座位'],
                [ '剩余座位','45'],

                ['渭南师范学院','体育学院'],
                ['体育学院', '543'],
                ['543', '剩余座位1'],
                [ '剩余座位1','30'],

                ['渭南师范学院','音乐学院'],
                ['音乐学院', '3212'],
                ['3212', '剩余座位3'],
                [ '剩余座位3','36'],

                ['渭南师范学院','外国语学院'],
                ['外国语学院', '2312'],
                ['2312', '剩余座位4'],
                [ '剩余座位4','40'],

                ['渭南师范学院','经管学院'],
                ['经管学院', '2313'],
                ['2313', '剩余座位5'],
                [ '剩余座位5','40']
            ]
        }]
    });

</script>