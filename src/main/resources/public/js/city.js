cytoscape({
  container: document.getElementById('cy'),

  layout: {
    name: 'cose',
    padding: 10
  },
  style: cytoscape.stylesheet()
    .selector('#l')
      .css({
        'width' : 200,
        //'height' : 180,
        'background-image': '/testx.svg',
        'margin':'0 auto',
        'display':'block',
        'background-position' : 'right top',
        'background-fit': 'cover',
      })
    .selector('node')
      .css({
        'shape': 'rectangle',
        //'width': 'mapData(weight, 40, 80, 20, 60)',
        'content': 'data(name)',
        'text-valign': 'center',
        'text-outline-width': 2,
        'text-outline-color': 'data(faveColor)',
        'background-color': 'data(faveColor)',
        'color': '#fff',
        //'white-space': 'pre',
        //"text-wrap": "wrap",
        "text-valign": "top",
        //"text-halign": "right"
      })
    .selector(':selected')
      .css({
        'border-width': 3,
        'border-color': '#333'
      })
    .selector('edge')
      .css({
        'curve-style': 'bezier',
        'opacity': 0.666,
        'width': 'mapData(strength, 70, 100, 2, 6)',
        'target-arrow-shape': 'triangle',
        'source-arrow-shape': 'circle',
        'line-color': 'data(faveColor)',
        'source-arrow-color': 'data(faveColor)',
        'target-arrow-color': 'data(faveColor)'
      })
    .selector('edge.questionable')
      .css({
        'line-style': 'dotted',
        'target-arrow-shape': 'diamond'
      })
    .selector('.faded')
      .css({
        'opacity': 0.25,
        'text-opacity': 0
      }),

  elements: {
    nodes: [
      { data: { id: 'l', faveColor: '#6FB1FC', name: 'PRD\nSVC INSEE' }, classes: 'multiline-manual' },
      { data: { id: 'j', name: 'Beta', weight: 65, faveColor: '#6FB1FC', faveShape: 'triangle' } },
      { data: { id: 'e', name: 'Gamma', weight: 45, faveColor: '#EDA1ED', faveShape: 'ellipse' } },
      { data: { id: 'k', name: 'Delta', weight: 75, faveColor: '#86B342', faveShape: 'octagon' } },
      { data: { id: 'g', name: 'Iota', weight: 70, faveColor: '#F5A45D', faveShape: 'rectangle' } }
    ],
    edges: [
      { data: { source: 'l', target: 'e', faveColor: '#6FB1FC', strength: 90 } },
      { data: { source: 'j', target: 'e', faveColor: '#6FB1FC', strength: 90 } },
      { data: { source: 'j', target: 'k', faveColor: '#6FB1FC', strength: 70 } },
      { data: { source: 'j', target: 'g', faveColor: '#6FB1FC', strength: 80 } },

      { data: { source: 'e', target: 'j', faveColor: '#EDA1ED', strength: 95 } },
      { data: { source: 'e', target: 'k', faveColor: '#EDA1ED', strength: 60 }, classes: 'questionable' },

      { data: { source: 'k', target: 'j', faveColor: '#86B342', strength: 100 } },
      { data: { source: 'k', target: 'e', faveColor: '#86B342', strength: 100 } },
      { data: { source: 'k', target: 'g', faveColor: '#86B342', strength: 100 } },

      { data: { source: 'g', target: 'j', faveColor: '#F5A45D', strength: 90 } }
    ]
  },

  ready: function(){
    window.cy = this;
  }
});