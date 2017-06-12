var allcours = JSON.parse(_cours);
var stats = JSON.parse(_stats);
var config = {
    strokeWidth: 2,
    easing: 'easeInOut',
    duration: 1400,
    color: '#6159a6',
    trailColor: '#eee',
    trailWidth: 2,
    svgStyle: {width: '100%', height: '100%'},
    text: {
        style: {
            color: '#999',
            position: 'absolute',
            right: '0',
            top: '20px',
            padding: 0,
            margin: 0,
            transform: null
        },
        autoStyleContainer: false
    },
    step: function (state, bar) {
        bar.setText(Math.round(bar.value() * 100) + ' %');
    }
};

var barTab = [];
var size = 1;
for (var i = 0; i < allcours.length; i++) {
    barTab[i] = new ProgressBar.Line('#container' + '_' + allcours[i], config);
    barTab[i].animate(stats[i]);
}
