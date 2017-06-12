var bar = new ProgressBar.Line(container, {
  strokeWidth: 2,
  easing: 'easeInOut',
  duration: 1400,
  color: '#6159a6',
  trailColor: '#eee',
  trailWidth: 2,
  svgStyle: {width: '100%', height: '100%'},
  text: {
    style: {
      // Text color.
      // Default: same as stroke color (options.color)
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
  step: (state, bar) => {
    bar.setText(Math.round(bar.value() * 100) + ' %');
  }
});

bar.animate(0.5);