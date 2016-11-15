(function(){function aa(a) {
  return function(b) {
    this[a] = b
  }
}
function g(a) {
  return function() {
    return this[a]
  }
}
var k, m = this;
function ba(a) {
  a = a.split(".");
  for(var b = m, c;c = a.shift();) {
    if(null != b[c]) {
      b = b[c]
    }else {
      return null
    }
  }
  return b
}
function ca(a) {
  var b = typeof a;
  if("object" == b) {
    if(a) {
      if(a instanceof Array) {
        return"array"
      }
      if(a instanceof Object) {
        return b
      }
      var c = Object.prototype.toString.call(a);
      if("[object Window]" == c) {
        return"object"
      }
      if("[object Array]" == c || "number" == typeof a.length && "undefined" != typeof a.splice && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("splice")) {
        return"array"
      }
      if("[object Function]" == c || "undefined" != typeof a.call && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("call")) {
        return"function"
      }
    }else {
      return"null"
    }
  }else {
    if("function" == b && "undefined" == typeof a.call) {
      return"object"
    }
  }
  return b
}
function da(a) {
  return"array" == ca(a)
}
function ea(a) {
  var b = ca(a);
  return"array" == b || "object" == b && "number" == typeof a.length
}
function n(a) {
  return"string" == typeof a
}
function ha(a) {
  var b = typeof a;
  return"object" == b && null != a || "function" == b
}
var ia = "closure_uid_" + (1E9 * Math.random() >>> 0), ja = 0;
function ka(a, b, c) {
  return a.call.apply(a.bind, arguments)
}
function la(a, b, c) {
  if(!a) {
    throw Error();
  }
  if(2 < arguments.length) {
    var d = Array.prototype.slice.call(arguments, 2);
    return function() {
      var c = Array.prototype.slice.call(arguments);
      Array.prototype.unshift.apply(c, d);
      return a.apply(b, c)
    }
  }
  return function() {
    return a.apply(b, arguments)
  }
}
function p(a, b, c) {
  p = Function.prototype.bind && -1 != Function.prototype.bind.toString().indexOf("native code") ? ka : la;
  return p.apply(null, arguments)
}
var q = Date.now || function() {
  return+new Date
};
function r(a, b) {
  var c = a.split("."), d = m;
  c[0] in d || !d.execScript || d.execScript("var " + c[0]);
  for(var e;c.length && (e = c.shift());) {
    c.length || void 0 === b ? d = d[e] ? d[e] : d[e] = {} : d[e] = b
  }
}
function s(a, b) {
  function c() {
  }
  c.prototype = b.prototype;
  a.g = b.prototype;
  a.prototype = new c
}
;function ma() {
  for(var a = window.self, b = 0, c = "";a !== window.top && a.parent;) {
    try {
      if(a.parent && a.parent.location && !a.parent.location.href) {
        throw"HandleSafari";
      }
    }catch(d) {
      if(c = c || a, 2 > b) {
        b++
      }else {
        break
      }
    }
    a = a.parent
  }
  c = c || a;
  a = (a = c.document.referrer.match(/[^?]+/)) ? a[0] : "";
  a = a.slice(0, 128);
  this.Ld = b;
  this.Md = c.location.hostname;
  this.Nd = a;
  this.Xa = c.location.href
}
;function na(a) {
  Error.captureStackTrace ? Error.captureStackTrace(this, na) : this.stack = Error().stack || "";
  a && (this.message = String(a))
}
s(na, Error);
na.prototype.name = "CustomError";
var oa;
function pa(a, b) {
  for(var c = a.split("%s"), d = "", e = Array.prototype.slice.call(arguments, 1);e.length && 1 < c.length;) {
    d += c.shift() + e.shift()
  }
  return d + c.join("%s")
}
function t(a) {
  if(!qa.test(a)) {
    return a
  }
  -1 != a.indexOf("\x26") && (a = a.replace(ra, "\x26amp;"));
  -1 != a.indexOf("\x3c") && (a = a.replace(sa, "\x26lt;"));
  -1 != a.indexOf("\x3e") && (a = a.replace(ta, "\x26gt;"));
  -1 != a.indexOf('"') && (a = a.replace(ua, "\x26quot;"));
  return a
}
var ra = /&/g, sa = /</g, ta = />/g, ua = /\"/g, qa = /[&<>\"]/;
function va(a, b) {
  for(var c = 0, d = String(a).replace(/^[\s\xa0]+|[\s\xa0]+$/g, "").split("."), e = String(b).replace(/^[\s\xa0]+|[\s\xa0]+$/g, "").split("."), f = Math.max(d.length, e.length), h = 0;0 == c && h < f;h++) {
    var l = d[h] || "", v = e[h] || "", fa = RegExp("(\\d*)(\\D*)", "g"), ga = RegExp("(\\d*)(\\D*)", "g");
    do {
      var w = fa.exec(l) || ["", "", ""], x = ga.exec(v) || ["", "", ""];
      if(0 == w[0].length && 0 == x[0].length) {
        break
      }
      c = ((0 == w[1].length ? 0 : parseInt(w[1], 10)) < (0 == x[1].length ? 0 : parseInt(x[1], 10)) ? -1 : (0 == w[1].length ? 0 : parseInt(w[1], 10)) > (0 == x[1].length ? 0 : parseInt(x[1], 10)) ? 1 : 0) || ((0 == w[2].length) < (0 == x[2].length) ? -1 : (0 == w[2].length) > (0 == x[2].length) ? 1 : 0) || (w[2] < x[2] ? -1 : w[2] > x[2] ? 1 : 0)
    }while(0 == c)
  }
  return c
}
;function wa(a, b) {
  b.unshift(a);
  na.call(this, pa.apply(null, b));
  b.shift();
  this.Qd = a
}
s(wa, na);
wa.prototype.name = "AssertionError";
function xa(a, b) {
  throw new wa("Failure" + (a ? ": " + a : ""), Array.prototype.slice.call(arguments, 1));
}
;var u = Array.prototype, ya = u.indexOf ? function(a, b, c) {
  return u.indexOf.call(a, b, c)
} : function(a, b, c) {
  c = null == c ? 0 : 0 > c ? Math.max(0, a.length + c) : c;
  if(n(a)) {
    return n(b) && 1 == b.length ? a.indexOf(b, c) : -1
  }
  for(;c < a.length;c++) {
    if(c in a && a[c] === b) {
      return c
    }
  }
  return-1
}, za = u.forEach ? function(a, b, c) {
  u.forEach.call(a, b, c)
} : function(a, b, c) {
  for(var d = a.length, e = n(a) ? a.split("") : a, f = 0;f < d;f++) {
    f in e && b.call(c, e[f], f, a)
  }
}, Aa = u.filter ? function(a, b, c) {
  return u.filter.call(a, b, c)
} : function(a, b, c) {
  for(var d = a.length, e = [], f = 0, h = n(a) ? a.split("") : a, l = 0;l < d;l++) {
    if(l in h) {
      var v = h[l];
      b.call(c, v, l, a) && (e[f++] = v)
    }
  }
  return e
};
function Ba(a, b) {
  var c = ya(a, b), d;
  (d = 0 <= c) && u.splice.call(a, c, 1);
  return d
}
function Ca(a) {
  return u.concat.apply(u, arguments)
}
function Da(a) {
  var b = a.length;
  if(0 < b) {
    for(var c = Array(b), d = 0;d < b;d++) {
      c[d] = a[d]
    }
    return c
  }
  return[]
}
function Ea(a, b, c) {
  return 2 >= arguments.length ? u.slice.call(a, b) : u.slice.call(a, b, c)
}
;var y, Fa, Ga, Ha;
function Ia() {
  return m.navigator ? m.navigator.userAgent : null
}
Ha = Ga = Fa = y = !1;
var Ja;
if(Ja = Ia()) {
  var Ka = m.navigator;
  y = 0 == Ja.lastIndexOf("Opera", 0);
  Fa = !y && (-1 != Ja.indexOf("MSIE") || -1 != Ja.indexOf("Trident"));
  Ga = !y && -1 != Ja.indexOf("WebKit");
  Ha = !y && !Ga && !Fa && "Gecko" == Ka.product
}
var La = y, z = Fa, A = Ha, B = Ga, Ma = m.navigator, Na = -1 != (Ma && Ma.platform || "").indexOf("Mac");
function Oa() {
  var a = m.document;
  return a ? a.documentMode : void 0
}
var Pa;
a: {
  var Qa = "", Ra;
  if(La && m.opera) {
    var Sa = m.opera.version, Qa = "function" == typeof Sa ? Sa() : Sa
  }else {
    if(A ? Ra = /rv\:([^\);]+)(\)|;)/ : z ? Ra = /\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/ : B && (Ra = /WebKit\/(\S+)/), Ra) {
      var Ta = Ra.exec(Ia()), Qa = Ta ? Ta[1] : ""
    }
  }
  if(z) {
    var Ua = Oa();
    if(Ua > parseFloat(Qa)) {
      Pa = String(Ua);
      break a
    }
  }
  Pa = Qa
}
var Va = {};
function C(a) {
  return Va[a] || (Va[a] = 0 <= va(Pa, a))
}
var Wa = m.document, Xa = Wa && z ? Oa() || ("CSS1Compat" == Wa.compatMode ? parseInt(Pa, 10) : 5) : void 0;
var Ya = !z || z && 9 <= Xa, Za = !A && !z || z && z && 9 <= Xa || A && C("1.9.1");
z && C("9");
function $a(a, b) {
  var c;
  c = a.className;
  c = n(c) && c.match(/\S+/g) || [];
  for(var d = Ea(arguments, 1), e = c.length + d.length, f = c, h = 0;h < d.length;h++) {
    0 <= ya(f, d[h]) || f.push(d[h])
  }
  a.className = c.join(" ");
  return c.length == e
}
;function ab(a, b, c) {
  for(var d in a) {
    b.call(c, a[d], d, a)
  }
}
function bb(a) {
  var b = [], c = 0, d;
  for(d in a) {
    b[c++] = a[d]
  }
  return b
}
function cb(a) {
  var b = [], c = 0, d;
  for(d in a) {
    b[c++] = d
  }
  return b
}
var db = "constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");
function eb(a, b) {
  for(var c, d, e = 1;e < arguments.length;e++) {
    d = arguments[e];
    for(c in d) {
      a[c] = d[c]
    }
    for(var f = 0;f < db.length;f++) {
      c = db[f], Object.prototype.hasOwnProperty.call(d, c) && (a[c] = d[c])
    }
  }
}
;function fb(a) {
  return a ? new gb(hb(a)) : oa || (oa = new gb)
}
function ib(a, b) {
  ab(b, function(b, d) {
    "style" == d ? a.style.cssText = b : "class" == d ? a.className = b : "for" == d ? a.htmlFor = b : d in jb ? a.setAttribute(jb[d], b) : 0 == d.lastIndexOf("aria-", 0) || 0 == d.lastIndexOf("data-", 0) ? a.setAttribute(d, b) : a[d] = b
  })
}
var jb = {cellpadding:"cellPadding", cellspacing:"cellSpacing", colspan:"colSpan", frameborder:"frameBorder", height:"height", maxlength:"maxLength", role:"role", rowspan:"rowSpan", type:"type", usemap:"useMap", valign:"vAlign", width:"width"};
function kb(a, b, c) {
  function d(c) {
    c && b.appendChild(n(c) ? a.createTextNode(c) : c)
  }
  for(var e = 2;e < c.length;e++) {
    var f = c[e];
    !ea(f) || ha(f) && 0 < f.nodeType ? d(f) : za(lb(f) ? Da(f) : f, d)
  }
}
function mb(a) {
  a && a.parentNode && a.parentNode.removeChild(a)
}
function hb(a) {
  return 9 == a.nodeType ? a : a.ownerDocument || a.document
}
function lb(a) {
  if(a && "number" == typeof a.length) {
    if(ha(a)) {
      return"function" == typeof a.item || "string" == typeof a.item
    }
    if("function" == ca(a)) {
      return"function" == typeof a.item
    }
  }
  return!1
}
function gb(a) {
  this.G = a || m.document || document
}
k = gb.prototype;
k.Fa = fb;
k.p = function(a) {
  return n(a) ? this.G.getElementById(a) : a
};
k.ia = function(a, b, c) {
  var d = this.G, e = arguments, f = e[0], h = e[1];
  if(!Ya && h && (h.name || h.type)) {
    f = ["\x3c", f];
    h.name && f.push(' name\x3d"', t(h.name), '"');
    if(h.type) {
      f.push(' type\x3d"', t(h.type), '"');
      var l = {};
      eb(l, h);
      delete l.type;
      h = l
    }
    f.push("\x3e");
    f = f.join("")
  }
  f = d.createElement(f);
  h && (n(h) ? f.className = h : da(h) ? $a.apply(null, [f].concat(h)) : ib(f, h));
  2 < e.length && kb(d, f, e);
  return f
};
k.createElement = function(a) {
  return this.G.createElement(a)
};
k.createTextNode = function(a) {
  return this.G.createTextNode(String(a))
};
k.appendChild = function(a, b) {
  a.appendChild(b)
};
k.Ea = function(a) {
  return Za && void 0 != a.children ? a.children : Aa(a.childNodes, function(a) {
    return 1 == a.nodeType
  })
};
z && C(8);
function nb(a) {
  if("function" == typeof a.m) {
    return a.m()
  }
  if(n(a)) {
    return a.split("")
  }
  if(ea(a)) {
    for(var b = [], c = a.length, d = 0;d < c;d++) {
      b.push(a[d])
    }
    return b
  }
  return bb(a)
}
function ob(a, b, c) {
  if("function" == typeof a.forEach) {
    a.forEach(b, c)
  }else {
    if(ea(a) || n(a)) {
      za(a, b, c)
    }else {
      var d;
      if("function" == typeof a.s) {
        d = a.s()
      }else {
        if("function" != typeof a.m) {
          if(ea(a) || n(a)) {
            d = [];
            for(var e = a.length, f = 0;f < e;f++) {
              d.push(f)
            }
          }else {
            d = cb(a)
          }
        }else {
          d = void 0
        }
      }
      for(var e = nb(a), f = e.length, h = 0;h < f;h++) {
        b.call(c, e[h], d && d[h], a)
      }
    }
  }
}
;function pb(a, b) {
  this.q = {};
  this.c = [];
  this.Va = this.e = 0;
  var c = arguments.length;
  if(1 < c) {
    if(c % 2) {
      throw Error("Uneven number of arguments");
    }
    for(var d = 0;d < c;d += 2) {
      this.set(arguments[d], arguments[d + 1])
    }
  }else {
    if(a) {
      a instanceof pb ? (c = a.s(), d = a.m()) : (c = cb(a), d = bb(a));
      for(var e = 0;e < c.length;e++) {
        this.set(c[e], d[e])
      }
    }
  }
}
k = pb.prototype;
k.m = function() {
  qb(this);
  for(var a = [], b = 0;b < this.c.length;b++) {
    a.push(this.q[this.c[b]])
  }
  return a
};
k.s = function() {
  qb(this);
  return this.c.concat()
};
k.F = function(a) {
  return D(this.q, a)
};
k.remove = function(a) {
  return D(this.q, a) ? (delete this.q[a], this.e--, this.Va++, this.c.length > 2 * this.e && qb(this), !0) : !1
};
function qb(a) {
  if(a.e != a.c.length) {
    for(var b = 0, c = 0;b < a.c.length;) {
      var d = a.c[b];
      D(a.q, d) && (a.c[c++] = d);
      b++
    }
    a.c.length = c
  }
  if(a.e != a.c.length) {
    for(var e = {}, c = b = 0;b < a.c.length;) {
      d = a.c[b], D(e, d) || (a.c[c++] = d, e[d] = 1), b++
    }
    a.c.length = c
  }
}
k.get = function(a, b) {
  return D(this.q, a) ? this.q[a] : b
};
k.set = function(a, b) {
  D(this.q, a) || (this.e++, this.c.push(a), this.Va++);
  this.q[a] = b
};
k.S = function() {
  return new pb(this)
};
function D(a, b) {
  return Object.prototype.hasOwnProperty.call(a, b)
}
;function rb(a) {
  return sb(a || arguments.callee.caller, [])
}
function sb(a, b) {
  var c = [];
  if(0 <= ya(b, a)) {
    c.push("[...circular reference...]")
  }else {
    if(a && 50 > b.length) {
      c.push(tb(a) + "(");
      for(var d = a.arguments, e = 0;e < d.length;e++) {
        0 < e && c.push(", ");
        var f;
        f = d[e];
        switch(typeof f) {
          case "object":
            f = f ? "object" : "null";
            break;
          case "string":
            break;
          case "number":
            f = String(f);
            break;
          case "boolean":
            f = f ? "true" : "false";
            break;
          case "function":
            f = (f = tb(f)) ? f : "[fn]";
            break;
          default:
            f = typeof f
        }
        40 < f.length && (f = f.substr(0, 40) + "...");
        c.push(f)
      }
      b.push(a);
      c.push(")\n");
      try {
        c.push(sb(a.caller, b))
      }catch(h) {
        c.push("[exception trying to get caller]\n")
      }
    }else {
      a ? c.push("[...long stack...]") : c.push("[end]")
    }
  }
  return c.join("")
}
function tb(a) {
  if(ub[a]) {
    return ub[a]
  }
  a = String(a);
  if(!ub[a]) {
    var b = /function ([^\(]+)/.exec(a);
    ub[a] = b ? b[1] : "[Anonymous]"
  }
  return ub[a]
}
var ub = {};
function E() {
  0 != vb && (this.Od = Error().stack, wb[this[ia] || (this[ia] = ++ja)] = this)
}
var vb = 0, wb = {};
E.prototype.Ba = !1;
E.prototype.n = function() {
  if(!this.Ba && (this.Ba = !0, this.f(), 0 != vb)) {
    var a = this[ia] || (this[ia] = ++ja);
    delete wb[a]
  }
};
E.prototype.f = function() {
  if(this.Pa) {
    for(;this.Pa.length;) {
      this.Pa.shift()()
    }
  }
};
var xb = !z || z && 9 <= Xa, yb = z && !C("9");
!B || C("528");
A && C("1.9b") || z && C("8") || La && C("9.5") || B && C("528");
A && !C("8") || z && C("9");
function F(a, b) {
  this.type = a;
  this.currentTarget = this.target = b
}
k = F.prototype;
k.f = function() {
};
k.n = function() {
};
k.u = !1;
k.defaultPrevented = !1;
k.Ra = !0;
k.stopPropagation = function() {
  this.u = !0
};
k.preventDefault = function() {
  this.defaultPrevented = !0;
  this.Ra = !1
};
function zb(a) {
  a.stopPropagation()
}
;function Ab(a) {
  return B ? "webkit" + a : La ? "o" + a.toLowerCase() : a.toLowerCase()
}
var Bb = {Gb:"click", Sb:"dblclick", wc:"mousedown", Cc:"mouseup", Bc:"mouseover", Ac:"mouseout", zc:"mousemove", xc:"mouseenter", yc:"mouseleave", yd:"selectstart", kc:"keypress", jc:"keydown", lc:"keyup", Cb:"blur", cc:"focus", Tb:"deactivate", dc:z ? "focusin" : "DOMFocusIn", ec:z ? "focusout" : "DOMFocusOut", Fb:"change", xd:"select", Ad:"submit", ic:"input", pd:"propertychange", $b:"dragstart", Vb:"drag", Xb:"dragenter", Zb:"dragover", Yb:"dragleave", ac:"drop", Wb:"dragend", Fd:"touchstart", 
Ed:"touchmove", Dd:"touchend", Cd:"touchcancel", Bb:"beforeunload", Nb:"consolemessage", Ob:"contextmenu", Ub:"DOMContentLoaded", Wa:"error", hc:"help", nc:"load", tc:"losecapture", Xc:"orientationchange", qd:"readystatechange", rd:"resize", wd:"scroll", Hd:"unload", gc:"hashchange", bd:"pagehide", cd:"pageshow", od:"popstate", Pb:"copy", dd:"paste", Rb:"cut", yb:"beforecopy", zb:"beforecut", Ab:"beforepaste", Wc:"online", Vc:"offline", vc:"message", Mb:"connect", xb:Ab("AnimationStart"), vb:Ab("AnimationEnd"), 
wb:Ab("AnimationIteration"), Gd:Ab("TransitionEnd"), gd:"pointerdown", nd:"pointerup", fd:"pointercancel", kd:"pointermove", md:"pointerover", ld:"pointerout", hd:"pointerenter", jd:"pointerleave", fc:"gotpointercapture", uc:"lostpointercapture", Dc:"MSGestureChange", Ec:"MSGestureEnd", Fc:"MSGestureHold", Gc:"MSGestureStart", Hc:"MSGestureTap", Ic:"MSGotPointerCapture", Jc:"MSInertiaStart", Kc:"MSLostPointerCapture", Lc:"MSPointerCancel", Mc:"MSPointerDown", Nc:"MSPointerEnter", Oc:"MSPointerHover", 
Pc:"MSPointerLeave", Qc:"MSPointerMove", Rc:"MSPointerOut", Sc:"MSPointerOver", Tc:"MSPointerUp", Bd:"textinput", Kb:"compositionstart", Lb:"compositionupdate", Jb:"compositionend", bc:"exit", oc:"loadabort", pc:"loadcommit", qc:"loadredirect", rc:"loadstart", sc:"loadstop", sd:"responsive", zd:"sizechanged", Id:"unresponsive", Jd:"visibilitychange"};
function Cb(a) {
  Cb[" "](a);
  return a
}
Cb[" "] = function() {
};
function G(a, b) {
  a && this.init(a, b)
}
s(G, F);
k = G.prototype;
k.target = null;
k.relatedTarget = null;
k.offsetX = 0;
k.offsetY = 0;
k.clientX = 0;
k.clientY = 0;
k.screenX = 0;
k.screenY = 0;
k.button = 0;
k.keyCode = 0;
k.charCode = 0;
k.ctrlKey = !1;
k.altKey = !1;
k.shiftKey = !1;
k.metaKey = !1;
k.kb = !1;
k.I = null;
k.init = function(a, b) {
  var c = this.type = a.type;
  F.call(this, c);
  this.target = a.target || a.srcElement;
  this.currentTarget = b;
  var d = a.relatedTarget;
  if(d) {
    if(A) {
      var e;
      a: {
        try {
          Cb(d.nodeName);
          e = !0;
          break a
        }catch(f) {
        }
        e = !1
      }
      e || (d = null)
    }
  }else {
    "mouseover" == c ? d = a.fromElement : "mouseout" == c && (d = a.toElement)
  }
  this.relatedTarget = d;
  this.offsetX = B || void 0 !== a.offsetX ? a.offsetX : a.layerX;
  this.offsetY = B || void 0 !== a.offsetY ? a.offsetY : a.layerY;
  this.clientX = void 0 !== a.clientX ? a.clientX : a.pageX;
  this.clientY = void 0 !== a.clientY ? a.clientY : a.pageY;
  this.screenX = a.screenX || 0;
  this.screenY = a.screenY || 0;
  this.button = a.button;
  this.keyCode = a.keyCode || 0;
  this.charCode = a.charCode || ("keypress" == c ? a.keyCode : 0);
  this.ctrlKey = a.ctrlKey;
  this.altKey = a.altKey;
  this.shiftKey = a.shiftKey;
  this.metaKey = a.metaKey;
  this.kb = Na ? a.metaKey : a.ctrlKey;
  this.state = a.state;
  this.I = a;
  a.defaultPrevented && this.preventDefault();
  delete this.u
};
k.stopPropagation = function() {
  G.g.stopPropagation.call(this);
  this.I.stopPropagation ? this.I.stopPropagation() : this.I.cancelBubble = !0
};
k.preventDefault = function() {
  G.g.preventDefault.call(this);
  var a = this.I;
  if(a.preventDefault) {
    a.preventDefault()
  }else {
    if(a.returnValue = !1, yb) {
      try {
        if(a.ctrlKey || 112 <= a.keyCode && 123 >= a.keyCode) {
          a.keyCode = -1
        }
      }catch(b) {
      }
    }
  }
};
k.f = function() {
};
var Db = "closure_listenable_" + (1E6 * Math.random() | 0);
function Eb(a) {
  try {
    return!(!a || !a[Db])
  }catch(b) {
    return!1
  }
}
var Fb = 0;
function Gb(a, b, c, d, e) {
  this.w = a;
  this.ca = null;
  this.src = b;
  this.type = c;
  this.capture = !!d;
  this.W = e;
  this.key = ++Fb;
  this.C = this.Q = !1
}
function Hb(a) {
  a.C = !0;
  a.w = null;
  a.ca = null;
  a.src = null;
  a.W = null
}
;function H(a) {
  this.src = a;
  this.d = {};
  this.P = 0
}
H.prototype.add = function(a, b, c, d, e) {
  var f = this.d[a];
  f || (f = this.d[a] = [], this.P++);
  var h = Ib(f, b, d, e);
  -1 < h ? (a = f[h], c || (a.Q = !1)) : (a = new Gb(b, this.src, a, !!d, e), a.Q = c, f.push(a));
  return a
};
H.prototype.remove = function(a, b, c, d) {
  if(!(a in this.d)) {
    return!1
  }
  var e = this.d[a];
  b = Ib(e, b, c, d);
  return-1 < b ? (Hb(e[b]), u.splice.call(e, b, 1), 0 == e.length && (delete this.d[a], this.P--), !0) : !1
};
function Jb(a, b) {
  var c = b.type;
  if(!(c in a.d)) {
    return!1
  }
  var d = Ba(a.d[c], b);
  d && (Hb(b), 0 == a.d[c].length && (delete a.d[c], a.P--));
  return d
}
H.prototype.O = function(a) {
  var b = 0, c;
  for(c in this.d) {
    if(!a || c == a) {
      for(var d = this.d[c], e = 0;e < d.length;e++) {
        ++b, Hb(d[e])
      }
      delete this.d[c];
      this.P--
    }
  }
  return b
};
H.prototype.K = function(a, b, c, d) {
  a = this.d[a];
  var e = -1;
  a && (e = Ib(a, b, c, d));
  return-1 < e ? a[e] : null
};
function Ib(a, b, c, d) {
  for(var e = 0;e < a.length;++e) {
    var f = a[e];
    if(!f.C && f.w == b && f.capture == !!c && f.W == d) {
      return e
    }
  }
  return-1
}
;var Kb = "closure_lm_" + (1E6 * Math.random() | 0), I = {}, Lb = 0;
function Mb(a, b, c, d, e) {
  if(da(b)) {
    for(var f = 0;f < b.length;f++) {
      Mb(a, b[f], c, d, e)
    }
    return null
  }
  c = Nb(c);
  if(Eb(a)) {
    a = a.ra(b, c, d, e)
  }else {
    if(!b) {
      throw Error("Invalid event type");
    }
    var f = !!d, h = J(a);
    h || (a[Kb] = h = new H(a));
    c = h.add(b, c, !1, d, e);
    c.ca || (d = Ob(), c.ca = d, d.src = a, d.w = c, a.addEventListener ? a.addEventListener(b, d, f) : a.attachEvent(b in I ? I[b] : I[b] = "on" + b, d), Lb++);
    a = c
  }
  return a
}
function Ob() {
  var a = Pb, b = xb ? function(c) {
    return a.call(b.src, b.w, c)
  } : function(c) {
    c = a.call(b.src, b.w, c);
    if(!c) {
      return c
    }
  };
  return b
}
function Qb(a, b, c, d, e) {
  if(da(b)) {
    for(var f = 0;f < b.length;f++) {
      Qb(a, b[f], c, d, e)
    }
  }else {
    c = Nb(c), Eb(a) ? a.xa(b, c, d, e) : a && (a = J(a)) && (b = a.K(b, c, !!d, e)) && Rb(b)
  }
}
function Rb(a) {
  if("number" == typeof a || !a || a.C) {
    return!1
  }
  var b = a.src;
  if(Eb(b)) {
    return Jb(b.o, a)
  }
  var c = a.type, d = a.ca;
  b.removeEventListener ? b.removeEventListener(c, d, a.capture) : b.detachEvent && b.detachEvent(c in I ? I[c] : I[c] = "on" + c, d);
  Lb--;
  (c = J(b)) ? (Jb(c, a), 0 == c.P && (c.src = null, b[Kb] = null)) : Hb(a);
  return!0
}
function Sb(a, b, c, d) {
  var e = 1;
  if(a = J(a)) {
    if(b = a.d[b]) {
      for(b = Da(b), a = 0;a < b.length;a++) {
        var f = b[a];
        f && (f.capture == c && !f.C) && (e &= !1 !== Tb(f, d))
      }
    }
  }
  return Boolean(e)
}
function Tb(a, b) {
  var c = a.w, d = a.W || a.src;
  a.Q && Rb(a);
  return c.call(d, b)
}
function Pb(a, b) {
  if(a.C) {
    return!0
  }
  if(!xb) {
    var c = b || ba("window.event"), d = new G(c, this), e = !0;
    if(!(0 > c.keyCode || void 0 != c.returnValue)) {
      a: {
        var f = !1;
        if(0 == c.keyCode) {
          try {
            c.keyCode = -1;
            break a
          }catch(h) {
            f = !0
          }
        }
        if(f || void 0 == c.returnValue) {
          c.returnValue = !0
        }
      }
      c = [];
      for(f = d.currentTarget;f;f = f.parentNode) {
        c.push(f)
      }
      for(var f = a.type, l = c.length - 1;!d.u && 0 <= l;l--) {
        d.currentTarget = c[l], e &= Sb(c[l], f, !0, d)
      }
      for(l = 0;!d.u && l < c.length;l++) {
        d.currentTarget = c[l], e &= Sb(c[l], f, !1, d)
      }
    }
    return e
  }
  return Tb(a, new G(b, this))
}
function J(a) {
  a = a[Kb];
  return a instanceof H ? a : null
}
var Ub = "__closure_events_fn_" + (1E9 * Math.random() >>> 0);
function Nb(a) {
  return"function" == ca(a) ? a : a[Ub] || (a[Ub] = function(b) {
    return a.handleEvent(b)
  })
}
;function K() {
  E.call(this);
  this.o = new H(this);
  this.Ya = this
}
s(K, E);
K.prototype[Db] = !0;
k = K.prototype;
k.Z = null;
k.wa = aa("Z");
k.addEventListener = function(a, b, c, d) {
  Mb(this, a, b, c, d)
};
k.removeEventListener = function(a, b, c, d) {
  Qb(this, a, b, c, d)
};
k.dispatchEvent = function(a) {
  var b, c = this.Z;
  if(c) {
    for(b = [];c;c = c.Z) {
      b.push(c)
    }
  }
  var c = this.Ya, d = a.type || a;
  if(n(a)) {
    a = new F(a, c)
  }else {
    if(a instanceof F) {
      a.target = a.target || c
    }else {
      var e = a;
      a = new F(d, c);
      eb(a, e)
    }
  }
  var e = !0, f;
  if(b) {
    for(var h = b.length - 1;!a.u && 0 <= h;h--) {
      f = a.currentTarget = b[h], e = Vb(f, d, !0, a) && e
    }
  }
  a.u || (f = a.currentTarget = c, e = Vb(f, d, !0, a) && e, a.u || (e = Vb(f, d, !1, a) && e));
  if(b) {
    for(h = 0;!a.u && h < b.length;h++) {
      f = a.currentTarget = b[h], e = Vb(f, d, !1, a) && e
    }
  }
  return e
};
k.f = function() {
  K.g.f.call(this);
  this.o && this.o.O(void 0);
  this.Z = null
};
k.ra = function(a, b, c, d) {
  return this.o.add(String(a), b, !1, c, d)
};
k.xa = function(a, b, c, d) {
  return this.o.remove(String(a), b, c, d)
};
function Vb(a, b, c, d) {
  b = a.o.d[String(b)];
  if(!b) {
    return!0
  }
  b = Da(b);
  for(var e = !0, f = 0;f < b.length;++f) {
    var h = b[f];
    if(h && !h.C && h.capture == c) {
      var l = h.w, v = h.W || h.src;
      h.Q && Jb(a.o, h);
      e = !1 !== l.call(v, d) && e
    }
  }
  return e && !1 != d.Ra
}
k.K = function(a, b, c, d) {
  return this.o.K(String(a), b, c, d)
};
function Wb(a, b) {
  K.call(this);
  this.X = a || 1;
  this.D = b || m;
  this.ga = p(this.tb, this);
  this.qa = q()
}
s(Wb, K);
k = Wb.prototype;
k.enabled = !1;
k.b = null;
k.tb = function() {
  if(this.enabled) {
    var a = q() - this.qa;
    0 < a && a < 0.8 * this.X ? this.b = this.D.setTimeout(this.ga, this.X - a) : (this.b && (this.D.clearTimeout(this.b), this.b = null), this.dispatchEvent(Xb), this.enabled && (this.b = this.D.setTimeout(this.ga, this.X), this.qa = q()))
  }
};
k.start = function() {
  this.enabled = !0;
  this.b || (this.b = this.D.setTimeout(this.ga, this.X), this.qa = q())
};
k.stop = function() {
  this.enabled = !1;
  this.b && (this.D.clearTimeout(this.b), this.b = null)
};
k.f = function() {
  Wb.g.f.call(this);
  this.stop();
  delete this.D
};
var Xb = "tick";
function Yb(a, b) {
  if("function" == ca(a)) {
    b && (a = p(a, b))
  }else {
    if(a && "function" == typeof a.handleEvent) {
      a = p(a.handleEvent, a)
    }else {
      throw Error("Invalid listener argument");
    }
  }
  return m.setTimeout(a, 500)
}
;var Zb = RegExp("^(?:([^:/?#.]+):)?(?://(?:([^/?#]*)@)?([^/#?]*?)(?::([0-9]+))?(?\x3d[/#?]|$))?([^?#]+)?(?:\\?([^#]*))?(?:#(.*))?$");
function $b(a) {
  if(ac) {
    ac = !1;
    var b = m.location;
    if(b) {
      var c = b.href;
      if(c && (c = (c = $b(c)[3] || null) && decodeURIComponent(c)) && c != b.hostname) {
        throw ac = !0, Error();
      }
    }
  }
  return a.match(Zb)
}
var ac = B;
function bc(a, b) {
  var c;
  if(a instanceof bc) {
    this.i = void 0 !== b ? b : a.i, cc(this, a.B), c = a.ea, L(this), this.ea = c, c = a.H, L(this), this.H = c, dc(this, a.ba), c = a.aa, L(this), this.aa = c, ec(this, a.A.S()), c = a.U, L(this), this.U = c
  }else {
    if(a && (c = $b(String(a)))) {
      this.i = !!b;
      cc(this, c[1] || "", !0);
      var d = c[2] || "";
      L(this);
      this.ea = d ? decodeURIComponent(d) : "";
      d = c[3] || "";
      L(this);
      this.H = d ? decodeURIComponent(d) : "";
      dc(this, c[4]);
      d = c[5] || "";
      L(this);
      this.aa = d ? decodeURIComponent(d) : "";
      ec(this, c[6] || "", !0);
      c = c[7] || "";
      L(this);
      this.U = c ? decodeURIComponent(c) : ""
    }else {
      this.i = !!b, this.A = new fc(null, 0, this.i)
    }
  }
}
k = bc.prototype;
k.B = "";
k.ea = "";
k.H = "";
k.ba = null;
k.aa = "";
k.U = "";
k.fb = !1;
k.i = !1;
k.toString = function() {
  var a = [], b = this.B;
  b && a.push(gc(b, hc), ":");
  if(b = this.H) {
    a.push("//");
    var c = this.ea;
    c && a.push(gc(c, hc), "@");
    a.push(encodeURIComponent(String(b)));
    b = this.ba;
    null != b && a.push(":", String(b))
  }
  if(b = this.aa) {
    this.H && "/" != b.charAt(0) && a.push("/"), a.push(gc(b, "/" == b.charAt(0) ? ic : jc))
  }
  (b = this.A.toString()) && a.push("?", b);
  (b = this.U) && a.push("#", gc(b, kc));
  return a.join("")
};
k.S = function() {
  return new bc(this)
};
function cc(a, b, c) {
  L(a);
  a.B = c ? b ? decodeURIComponent(b) : "" : b;
  a.B && (a.B = a.B.replace(/:$/, ""))
}
function dc(a, b) {
  L(a);
  if(b) {
    b = Number(b);
    if(isNaN(b) || 0 > b) {
      throw Error("Bad port number " + b);
    }
    a.ba = b
  }else {
    a.ba = null
  }
}
function ec(a, b, c) {
  L(a);
  b instanceof fc ? (a.A = b, a.A.ua(a.i)) : (c || (b = gc(b, lc)), a.A = new fc(b, 0, a.i))
}
function L(a) {
  if(a.fb) {
    throw Error("Tried to modify a read-only Uri");
  }
}
k.ua = function(a) {
  this.i = a;
  this.A && this.A.ua(a);
  return this
};
function gc(a, b) {
  return n(a) ? encodeURI(a).replace(b, mc) : null
}
function mc(a) {
  a = a.charCodeAt(0);
  return"%" + (a >> 4 & 15).toString(16) + (a & 15).toString(16)
}
var hc = /[#\/\?@]/g, jc = /[\#\?:]/g, ic = /[\#\?]/g, lc = /[\#\?@]/g, kc = /#/g;
function fc(a, b, c) {
  this.h = a || null;
  this.i = !!c
}
function M(a) {
  if(!a.a && (a.a = new pb, a.e = 0, a.h)) {
    for(var b = a.h.split("\x26"), c = 0;c < b.length;c++) {
      var d = b[c].indexOf("\x3d"), e = null, f = null;
      0 <= d ? (e = b[c].substring(0, d), f = b[c].substring(d + 1)) : e = b[c];
      e = decodeURIComponent(e.replace(/\+/g, " "));
      e = N(a, e);
      a.add(e, f ? decodeURIComponent(f.replace(/\+/g, " ")) : "")
    }
  }
}
k = fc.prototype;
k.a = null;
k.e = null;
k.add = function(a, b) {
  M(this);
  this.h = null;
  a = N(this, a);
  var c = this.a.get(a);
  c || this.a.set(a, c = []);
  c.push(b);
  this.e++;
  return this
};
k.remove = function(a) {
  M(this);
  a = N(this, a);
  return this.a.F(a) ? (this.h = null, this.e -= this.a.get(a).length, this.a.remove(a)) : !1
};
k.F = function(a) {
  M(this);
  a = N(this, a);
  return this.a.F(a)
};
k.s = function() {
  M(this);
  for(var a = this.a.m(), b = this.a.s(), c = [], d = 0;d < b.length;d++) {
    for(var e = a[d], f = 0;f < e.length;f++) {
      c.push(b[d])
    }
  }
  return c
};
k.m = function(a) {
  M(this);
  var b = [];
  if(n(a)) {
    this.F(a) && (b = Ca(b, this.a.get(N(this, a))))
  }else {
    a = this.a.m();
    for(var c = 0;c < a.length;c++) {
      b = Ca(b, a[c])
    }
  }
  return b
};
k.set = function(a, b) {
  M(this);
  this.h = null;
  a = N(this, a);
  this.F(a) && (this.e -= this.a.get(a).length);
  this.a.set(a, [b]);
  this.e++;
  return this
};
k.get = function(a, b) {
  var c = a ? this.m(a) : [];
  return 0 < c.length ? String(c[0]) : b
};
k.toString = function() {
  if(this.h) {
    return this.h
  }
  if(!this.a) {
    return""
  }
  for(var a = [], b = this.a.s(), c = 0;c < b.length;c++) {
    for(var d = b[c], e = encodeURIComponent(String(d)), d = this.m(d), f = 0;f < d.length;f++) {
      var h = e;
      "" !== d[f] && (h += "\x3d" + encodeURIComponent(String(d[f])));
      a.push(h)
    }
  }
  return this.h = a.join("\x26")
};
k.S = function() {
  var a = new fc;
  a.h = this.h;
  this.a && (a.a = this.a.S(), a.e = this.e);
  return a
};
function N(a, b) {
  var c = String(b);
  a.i && (c = c.toLowerCase());
  return c
}
k.ua = function(a) {
  a && !this.i && (M(this), this.h = null, ob(this.a, function(a, c) {
    var d = c.toLowerCase();
    c != d && (this.remove(c), this.remove(d), 0 < a.length && (this.h = null, this.a.set(N(this, d), Da(a)), this.e += a.length))
  }, this));
  this.i = a
};
function nc() {
  var a = new ma, a = (new bc(a.Xa)).B;
  0 !== a.indexOf("http") && (a = "https");
  return a
}
;nc();
var oc = {Eb:"breakStarted", Db:"breakEnded", ud:"scriptFetched", vd:"scriptTimeout", Qb:"custom", Hb:"clickThru", mc:"linearChanged", Ib:"companion", Uc:"noCompanion", ed:"paused", td:"resumed", Kd:"volumeChanged", $c:"overlayStarted", ad:"overlayStopped", Zc:"overlayExpanded", Yc:"overlayCollapsed", Wa:"error"};
function pc(a) {
  F.call(this, a)
}
s(pc, F);
function qc(a) {
  E.call(this);
  this.Ha = a;
  this.c = {}
}
s(qc, E);
var rc = [];
k = qc.prototype;
k.ra = function(a, b, c, d, e) {
  da(b) || (rc[0] = b, b = rc);
  for(var f = 0;f < b.length;f++) {
    var h = Mb(a, b[f], c || this.handleEvent, d || !1, e || this.Ha || this);
    if(!h) {
      break
    }
    this.c[h.key] = h
  }
  return this
};
k.xa = function(a, b, c, d, e) {
  if(da(b)) {
    for(var f = 0;f < b.length;f++) {
      this.xa(a, b[f], c, d, e)
    }
  }else {
    c = c || this.handleEvent, e = e || this.Ha || this, c = Nb(c), d = !!d, b = Eb(a) ? a.K(b, c, d, e) : a ? (a = J(a)) ? a.K(b, c, d, e) : null : null, b && (Rb(b), delete this.c[b.key])
  }
  return this
};
k.O = function() {
  ab(this.c, Rb);
  this.c = {}
};
k.f = function() {
  qc.g.f.call(this);
  this.O()
};
k.handleEvent = function() {
  throw Error("EventHandler.handleEvent not implemented");
};
function O(a, b, c, d, e) {
  this.reset(a, b, c, d, e)
}
O.prototype.ob = 0;
O.prototype.na = null;
O.prototype.ma = null;
var sc = 0;
O.prototype.reset = function(a, b, c, d, e) {
  this.ob = "number" == typeof e ? e : sc++;
  this.Ua = d || q();
  this.v = a;
  this.Na = b;
  this.Ma = c;
  delete this.na;
  delete this.ma
};
O.prototype.va = aa("v");
function P(a) {
  this.ib = a
}
P.prototype.j = null;
P.prototype.v = null;
P.prototype.r = null;
P.prototype.L = null;
function Q(a, b) {
  this.name = a;
  this.value = b
}
Q.prototype.toString = g("name");
var tc = new Q("SHOUT", 1200), uc = new Q("SEVERE", 1E3), vc = new Q("WARNING", 900), wc = new Q("INFO", 800), xc = new Q("CONFIG", 700), yc = new Q("ALL", 0);
k = P.prototype;
k.getParent = g("j");
k.Ea = function() {
  this.r || (this.r = {});
  return this.r
};
k.va = aa("v");
function zc(a) {
  if(a.v) {
    return a.v
  }
  if(a.j) {
    return zc(a.j)
  }
  xa("Root logger has no level set.");
  return null
}
k.log = function(a, b, c) {
  if(a.value >= zc(this).value) {
    for(a = this.cb(a, b, c), b = "log:" + a.Na, m.console && (m.console.timeStamp ? m.console.timeStamp(b) : m.console.markTimeline && m.console.markTimeline(b)), m.msWriteProfilerMark && m.msWriteProfilerMark(b), b = this;b;) {
      c = b;
      var d = a;
      if(c.L) {
        for(var e = 0, f = void 0;f = c.L[e];e++) {
          f(d)
        }
      }
      b = b.getParent()
    }
  }
};
k.cb = function(a, b, c) {
  var d = new O(a, String(b), this.ib);
  if(c) {
    d.na = c;
    var e;
    var f = arguments.callee.caller;
    try {
      var h;
      var l = ba("window.location.href");
      if(n(c)) {
        h = {message:c, name:"Unknown error", lineNumber:"Not available", fileName:l, stack:"Not available"}
      }else {
        var v, fa, ga = !1;
        try {
          v = c.lineNumber || c.Pd || "Not available"
        }catch(w) {
          v = "Not available", ga = !0
        }
        try {
          fa = c.fileName || c.filename || c.sourceURL || m.$googDebugFname || l
        }catch(x) {
          fa = "Not available", ga = !0
        }
        h = !ga && c.lineNumber && c.fileName && c.stack && c.message && c.name ? c : {message:c.message || "Not available", name:c.name || "UnknownError", lineNumber:v, fileName:fa, stack:c.stack || "Not available"}
      }
      e = "Message: " + t(h.message) + '\nUrl: \x3ca href\x3d"view-source:' + h.fileName + '" target\x3d"_new"\x3e' + h.fileName + "\x3c/a\x3e\nLine: " + h.lineNumber + "\n\nBrowser stack:\n" + t(h.stack + "-\x3e ") + "[end]\n\nJS stack traversal:\n" + t(rb(f) + "-\x3e ")
    }catch(Zc) {
      e = "Exception trying to expose exception! You win, we lose. " + Zc
    }
    d.ma = e
  }
  return d
};
k.info = function(a, b) {
  this.log(wc, a, b)
};
var Ac = {}, Bc = null;
function Cc() {
  Bc || (Bc = new P(""), Ac[""] = Bc, Bc.va(xc))
}
function Dc(a) {
  Cc();
  var b;
  if(!(b = Ac[a])) {
    b = new P(a);
    var c = a.lastIndexOf("."), d = a.substr(c + 1), c = Dc(a.substr(0, c));
    c.Ea()[d] = b;
    b.j = c;
    Ac[a] = b
  }
  return b
}
;function Ec(a) {
  "number" == typeof a && (a = Math.round(a) + "px");
  return a
}
;function R() {
}
R.bb = function() {
  return R.Ja ? R.Ja : R.Ja = new R
};
R.prototype.jb = 0;
R.prototype.Ga = function() {
  return":" + (this.jb++).toString(36)
};
function S(a) {
  K.call(this);
  this.ka = a || fb();
  this.nb = Fc
}
s(S, K);
S.prototype.eb = R.bb();
var Fc = null;
k = S.prototype;
k.Ia = null;
k.t = !1;
k.l = null;
k.nb = null;
k.hb = null;
k.j = null;
k.r = null;
k.R = null;
k.ub = !1;
function T(a) {
  return a.Ia || (a.Ia = a.eb.Ga())
}
k.p = g("l");
k.getParent = g("j");
k.wa = function(a) {
  if(this.j && this.j != a) {
    throw Error("Method not supported");
  }
  S.g.wa.call(this, a)
};
k.Fa = g("ka");
k.ia = function() {
  this.l = this.ka.createElement("div")
};
k.sa = function(a) {
  if(this.t) {
    throw Error("Component already rendered");
  }
  this.l || this.ia();
  a ? a.insertBefore(this.l, null) : this.ka.G.body.appendChild(this.l);
  this.j && !this.j.t || this.T()
};
k.T = function() {
  this.t = !0;
  Gc(this, function(a) {
    !a.t && a.p() && a.T()
  })
};
function Hc(a) {
  Gc(a, function(a) {
    a.t && Hc(a)
  });
  a.V && a.V.O();
  a.t = !1
}
k.f = function() {
  this.t && Hc(this);
  this.V && (this.V.n(), delete this.V);
  Gc(this, function(a) {
    a.n()
  });
  !this.ub && this.l && mb(this.l);
  this.j = this.hb = this.l = this.R = this.r = null;
  S.g.f.call(this)
};
function Gc(a, b) {
  a.r && za(a.r, b, void 0)
}
k.removeChild = function(a, b) {
  if(a) {
    var c = n(a) ? a : T(a), d;
    this.R && c ? (d = this.R, d = (c in d ? d[c] : void 0) || null) : d = null;
    a = d;
    if(c && a) {
      d = this.R;
      c in d && delete d[c];
      Ba(this.r, a);
      b && (Hc(a), a.l && mb(a.l));
      c = a;
      if(null == c) {
        throw Error("Unable to set parent component");
      }
      c.j = null;
      S.g.wa.call(c, null)
    }
  }
  if(!a) {
    throw Error("Child is not in parent component");
  }
  return a
};
var Ic = !1, U = "";
function Jc(a) {
  a = a.match(/[\d]+/g);
  if(!a) {
    return""
  }
  a.length = 3;
  return a.join(".")
}
if(navigator.plugins && navigator.plugins.length) {
  var Kc = navigator.plugins["Shockwave Flash"];
  Kc && (Ic = !0, Kc.description && (U = Jc(Kc.description)));
  navigator.plugins["Shockwave Flash 2.0"] && (Ic = !0, U = "2.0.0.11")
}else {
  if(navigator.mimeTypes && navigator.mimeTypes.length) {
    var Lc = navigator.mimeTypes["application/x-shockwave-flash"];
    (Ic = Lc && Lc.enabledPlugin) && (U = Jc(Lc.enabledPlugin.description))
  }else {
    try {
      var Mc = new ActiveXObject("ShockwaveFlash.ShockwaveFlash.7"), Ic = !0, U = Jc(Mc.GetVariable("$version"))
    }catch(Nc) {
      try {
        Mc = new ActiveXObject("ShockwaveFlash.ShockwaveFlash.6"), Ic = !0, U = "6.0.21"
      }catch(Oc) {
        try {
          Mc = new ActiveXObject("ShockwaveFlash.ShockwaveFlash"), Ic = !0, U = Jc(Mc.GetVariable("$version"))
        }catch(Pc) {
        }
      }
    }
  }
}
var Qc = U;
function V(a, b) {
  S.call(this, b);
  this.Ca = a;
  this.la = new qc(this);
  this.J = new pb
}
s(V, S);
var Rc = V.prototype, Sc = Dc("goog.ui.media.FlashObject");
Rc.gb = Sc;
k = V.prototype;
k.za = "window";
k.Aa = "#000000";
k.fa = "sameDomain";
function Tc(a, b, c) {
  a.ya = n(b) ? b : Math.round(b) + "px";
  a.pa = n(c) ? c : Math.round(c) + "px";
  if(a.p()) {
    b = W(a);
    c = a.ya;
    a = a.pa;
    if(void 0 == a) {
      throw Error("missing height argument");
    }
    b.style.width = Ec(c);
    b.style.height = Ec(a)
  }
}
k.T = function() {
  V.g.T.call(this);
  this.p().innerHTML = this.Da();
  this.ya && this.pa && Tc(this, this.ya, this.pa);
  this.la.ra(this.p(), bb(Bb), zb)
};
k.ia = function() {
  if(null != this.ta && !(0 <= va(Qc, this.ta))) {
    var a = this.gb;
    a && a.log(vc, "Required flash version not found:" + this.ta, void 0);
    throw Error("Method not supported");
  }
  a = this.Fa().createElement("div");
  a.className = "goog-ui-media-flash";
  this.l = a
};
k.Da = function() {
  for(var a = z ? '\x3cobject classid\x3d"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" id\x3d"%s" name\x3d"%s" class\x3d"%s"\x3e\x3cparam name\x3d"movie" value\x3d"%s"/\x3e\x3cparam name\x3d"quality" value\x3d"high"/\x3e\x3cparam name\x3d"FlashVars" value\x3d"%s"/\x3e\x3cparam name\x3d"bgcolor" value\x3d"%s"/\x3e\x3cparam name\x3d"AllowScriptAccess" value\x3d"%s"/\x3e\x3cparam name\x3d"allowFullScreen" value\x3d"true"/\x3e\x3cparam name\x3d"SeamlessTabbing" value\x3d"false"/\x3e%s\x3c/object\x3e' : 
  '\x3cembed quality\x3d"high" id\x3d"%s" name\x3d"%s" class\x3d"%s" src\x3d"%s" FlashVars\x3d"%s" bgcolor\x3d"%s" AllowScriptAccess\x3d"%s" allowFullScreen\x3d"true" SeamlessTabbing\x3d"false" type\x3d"application/x-shockwave-flash" pluginspage\x3d"http://www.macromedia.com/go/getflashplayer" %s\x3e\x3c/embed\x3e', b = z ? '\x3cparam name\x3d"wmode" value\x3d"%s"/\x3e' : "wmode\x3d%s", b = pa(b, this.za), c = this.J.s(), d = this.J.m(), e = [], f = 0;f < c.length;f++) {
    e.push(encodeURIComponent(String(c[f])) + "\x3d" + encodeURIComponent(String(d[f])))
  }
  return pa(a, T(this), T(this), "goog-ui-media-flash-object", t(this.Ca), t(e.join("\x26")), this.Aa, this.fa, b)
};
function W(a) {
  return a.p() ? a.p().firstChild : null
}
k.f = function() {
  V.g.f.call(this);
  this.J = null;
  this.la.n();
  this.la = null
};
k.M = function() {
  return this.t && this.p() ? W(this).readyState && 4 == W(this).readyState || W(this).PercentLoaded && 100 == W(this).PercentLoaded() ? !0 : !1 : !1
};
R.prototype.Ga = function(a) {
  "number" != typeof window[a] && (window[a] = 0);
  return function() {
    return":" + (window[a]++).toString(36)
  }
}("__adaptv__last_unique_id__");
function X(a, b, c) {
  this.ha = b;
  this.$ = window;
  V.call(this, a, c)
}
s(X, V);
X.prototype.sa = function(a) {
  X.g.sa.call(this, a);
  a && (this.$ = hb(a) ? hb(a).parentWindow || hb(a).defaultView : window);
  this.b = new Wb(50);
  this.b.start();
  Mb(this.b, Xb, function() {
    var a;
    (a = this.M() && null != (this.$ || window).__adaptv__.jsproxy) && !(a = !this.ha) && (a = T(this), a = (this.$ || window).__adaptv__.jsproxy[a][this.ha]);
    a && (this.b.stop(), this.b.n(), this.b = null, this.dispatchEvent(new pc("ready")))
  }, !1, this)
};
X.prototype.Da = function() {
  for(var a = !z || z && 11 <= Xa ? '\x3cembed quality\x3d"high" id\x3d"%s" name\x3d"%s" class\x3d"%s" src\x3d"%s" FlashVars\x3d"%s" bgcolor\x3d"%s" AllowScriptAccess\x3d"%s" allowFullScreen\x3d"true" SeamlessTabbing\x3d"false" type\x3d"application/x-shockwave-flash" pluginspage\x3d"http://www.macromedia.com/go/getflashplayer" %s\x3e\x3c/embed\x3e' : '\x3cobject classid\x3d"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" id\x3d"%s" name\x3d"%s" class\x3d"%s"\x3e\x3cparam name\x3d"movie" value\x3d"%s"/\x3e\x3cparam name\x3d"quality" value\x3d"high"/\x3e\x3cparam name\x3d"FlashVars" value\x3d"%s"/\x3e\x3cparam name\x3d"bgcolor" value\x3d"%s"/\x3e\x3cparam name\x3d"AllowScriptAccess" value\x3d"%s"/\x3e\x3cparam name\x3d"allowFullScreen" value\x3d"true"/\x3e\x3cparam name\x3d"SeamlessTabbing" value\x3d"false"/\x3e%s\x3c/object\x3e', 
  b = !z || z && 11 <= Xa ? "wmode\x3d%s" : '\x3cparam name\x3d"wmode" value\x3d"%s"/\x3e', b = pa(b, this.za), c = this.J.s(), d = this.J.m(), e = [], f = 0;f < c.length;f++) {
    e.push(encodeURIComponent(String(c[f])) + "\x3d" + encodeURIComponent(String(d[f])))
  }
  return pa(a, T(this), T(this), "goog-ui-media-flash-object", t(this.Ca), t(e.join("\x26")), this.Aa, this.fa, b)
};
X.prototype.M = function() {
  var a = !1;
  try {
    a = X.g.M.call(this)
  }catch(b) {
  }
  return a || "PercentLoaded" in W(this) && 100 == W(this).PercentLoaded()
};
X.prototype.n = function() {
  this.b && this.b.stop();
  this.b && this.b.n();
  this.$ = this.ha = this.b = null;
  var a = W(this);
  if(a) {
    if(a) {
      if(Eb(a)) {
        a.o && a.o.O(void 0)
      }else {
        var b = J(a);
        if(b) {
          var c = 0, d;
          for(d in b.d) {
            for(var e = Da(b.d[d]), f = 0;f < e.length;++f) {
              Rb(e[f]) && ++c
            }
          }
        }
      }
    }
    mb(a)
  }
  X.g.n.call(this)
};
function Y(a) {
  this.Y = Dc("adaptv.ads.VPAIDAd");
  this.Y.info("VPAIDAd()");
  this.ja = a;
  this.d = []
}
function Z(a, b, c) {
  za(a.d, function(a) {
    a.type == b && (c = c || {}, a.fn.call(a.scope, {target:this, type:b, data:c}))
  }, a)
}
function Uc(a) {
  var b = Vc, c = Yb(function() {
    m.clearTimeout(c);
    Z(this, b, void 0)
  }, a)
}
k = Y.prototype;
k.initAd = function(a, b, c) {
  "number" == typeof a && "number" == typeof b && 0 < a && 0 < b || (a = 500, b = 400);
  this.width = a;
  this.height = b;
  var d = nc() + "://redir.adap.tv/redir/client/swfloader.swf?id\x3dswfloader", e = new X(d);
  Tc(e, a, b);
  e.za = "opaque";
  e.ta = "9.0.124";
  e.fa = "always";
  e.sa(n(this.ja) ? document.getElementById(this.ja) : this.ja);
  e.p().id = "adaptvDiv";
  var f = setInterval(p(function() {
    e.M() && (null != window.__adaptv__.jsproxy && null != window.__adaptv__.jsproxy[T(e)]) && (e.M() && null != window.__adaptv__.jsproxy) && (clearInterval(f), this.da = window.__adaptv__.jsproxy[T(e)].swfloader, this.da.__on("adaptv_swfloader_SwfLoaded", function() {
      this.Y.info("swfloader loaded");
      this.N = new Wb(300);
      this.N.start();
      Mb(this.N, Xb, function() {
        if(null != window.__adaptv__.jsproxy[T(e)].adplayer) {
          this.N.stop();
          this.N.n();
          this.N = null;
          this.k = window.__adaptv__.jsproxy[T(e)].adplayer;
          var d = function(a) {
            this.Y.info("[AdPlayerEvent] " + a.type, a.data);
            switch(a.type) {
              case "scriptFetched":
                !0 === a.data.hasPreroll ? Z(this, Wc) : Z(this, Xc, {message:a.data.message || "No preroll ad available in control script"});
                break;
              case "breakStarted":
                Z(this, Yc);
                break;
              case "clickThru":
                Z(this, $c, a.data);
                break;
              case "companion":
                Z(this, ad, a.data);
                break;
              case "breakEnded":
                Uc(this);
                break;
              case "error":
                Z(this, Xc), Uc(this)
            }
          };
          ab(oc, function(a) {
            this.k.__on(a, d, this)
          }, this);
          this.k.apiVersion("2.1");
          this.k.setMetadata(c);
          this.k.setContentSize(a, b);
          this.k.setHTMLSize(a, b, 0, 0);
          this.k.fetchScript()
        }
      }, !1, this)
    }, this), this.da.__on("adaptv_swfloader_SwfLoadError", function() {
      this.Y.info("swfloader load error");
      Z(this, Xc)
    }, this), this.da.init(a, b), this.da.load(nc() + "://redir.adap.tv/redir/client/static/AS3AdPlayer.swf?js\x3dadplayer", null, {events:bb(oc)}))
  }, this), 500)
};
k.startAd = function() {
  this.k.startBreak()
};
k.stopAd = function() {
  this.k.endBreak()
};
k.Oa = function(a, b, c) {
  this.d.push({type:a, fn:b, scope:c})
};
k.setVolume = function(a) {
  this.k.setVolume(a)
};
k.getVolume = function() {
  return this.k.getVolume()
};
k.n = function() {
  this.k.destroy()
};
var Wc = "AdLoaded", Yc = "AdStarted", ad = "AdCompanionDisplay", $c = "AdClickThru", Vc = "AdStopped", Xc = "AdError";
function bd() {
  this.Qa = q()
}
var cd = new bd;
bd.prototype.set = aa("Qa");
bd.prototype.reset = function() {
  this.set(q())
};
bd.prototype.get = g("Qa");
function dd(a) {
  this.lb = a || "";
  this.sb = cd
}
k = dd.prototype;
k.$a = !0;
k.Sa = !0;
k.qb = !0;
k.pb = !0;
k.Ta = !1;
k.rb = !1;
function $(a) {
  return 10 > a ? "0" + a : String(a)
}
function ed(a, b) {
  var c = (a.Ua - b) / 1E3, d = c.toFixed(3), e = 0;
  if(1 > c) {
    e = 2
  }else {
    for(;100 > c;) {
      e++, c *= 10
    }
  }
  for(;0 < e--;) {
    d = " " + d
  }
  return d
}
function fd(a) {
  dd.call(this, a)
}
s(fd, dd);
function gd() {
  this.mb = p(this.Za, this);
  this.oa = new fd;
  this.oa.Sa = !1;
  this.Ka = this.oa.Ta = !1;
  this.La = "";
  this.ab = {}
}
gd.prototype.Za = function(a) {
  if(!this.ab[a.Ma]) {
    var b;
    b = this.oa;
    var c = [];
    c.push(b.lb, " ");
    if(b.Sa) {
      var d = new Date(a.Ua);
      c.push("[", $(d.getFullYear() - 2E3) + $(d.getMonth() + 1) + $(d.getDate()) + " " + $(d.getHours()) + ":" + $(d.getMinutes()) + ":" + $(d.getSeconds()) + "." + $(Math.floor(d.getMilliseconds() / 10)), "] ")
    }
    b.qb && c.push("[", ed(a, b.sb.get()), "s] ");
    b.pb && c.push("[", a.Ma, "] ");
    b.rb && c.push("[", a.v.name, "] ");
    c.push(a.Na);
    b.Ta && a.na && c.push("\n", a.ma);
    b.$a && c.push("\n");
    b = c.join("");
    if(c = hd) {
      switch(a.v) {
        case tc:
          id(c, "info", b);
          break;
        case uc:
          id(c, "error", b);
          break;
        case vc:
          id(c, "warn", b);
          break;
        default:
          id(c, "debug", b)
      }
    }else {
      window.opera ? window.opera.postError(b) : this.La += b
    }
  }
};
var hd = window.console;
function id(a, b, c) {
  if(a[b]) {
    a[b](c)
  }else {
    a.log(c)
  }
}
;r("__adaptv__.debug.configure", function(a, b) {
  Dc(a).va(b || yc);
  var c = new gd;
  if(!0 != c.Ka) {
    Cc();
    var d = Bc, e = c.mb;
    d.L || (d.L = []);
    d.L.push(e);
    c.Ka = !0
  }
});
r("__adaptv__.debug.log", function(a) {
  Dc("adaptv.page").info(a)
});
r("__adaptv__.ads.VPAIDAd", Y);
r("__adaptv__.ads.VPAIDAd.prototype.initAd", Y.prototype.initAd);
r("__adaptv__.ads.VPAIDAd.prototype.startAd", Y.prototype.startAd);
r("__adaptv__.ads.VPAIDAd.prototype.stopAd", Y.prototype.stopAd);
r("__adaptv__.ads.VPAIDAd.prototype.on", Y.prototype.Oa);
r("__adaptv__.ads.VPAIDAd.prototype.setVolume", Y.prototype.setVolume);
r("__adaptv__.ads.VPAIDAd.prototype.getVolume", Y.prototype.getVolume);
r("__adaptv__.ads.VPAIDEvent.AdLoaded", Wc);
r("__adaptv__.ads.VPAIDEvent.AdStarted", Yc);
r("__adaptv__.ads.VPAIDEvent.AdCompanionDisplay", ad);
r("__adaptv__.ads.VPAIDEvent.AdClickThru", $c);
r("__adaptv__.ads.VPAIDEvent.AdStopped", Vc);
r("__adaptv__.ads.VPAIDEvent.AdError", Xc);
r("__adaptv__.ads.vpaid.VPAIDAd", Y);
r("__adaptv__.ads.vpaid.VPAIDAd.prototype.initAd", Y.prototype.initAd);
r("__adaptv__.ads.vpaid.VPAIDAd.prototype.startAd", Y.prototype.startAd);
r("__adaptv__.ads.vpaid.VPAIDAd.prototype.stopAd", Y.prototype.stopAd);
r("__adaptv__.ads.vpaid.VPAIDAd.prototype.on", Y.prototype.Oa);
r("__adaptv__.ads.vpaid.VPAIDAd.prototype.setVolume", Y.prototype.setVolume);
r("__adaptv__.ads.vpaid.VPAIDAd.prototype.getVolume", Y.prototype.getVolume);
r("__adaptv__.ads.vpaid.VPAIDEvent.AdLoaded", Wc);
r("__adaptv__.ads.vpaid.VPAIDEvent.AdStarted", Yc);
r("__adaptv__.ads.vpaid.VPAIDEvent.AdCompanionDisplay", ad);
r("__adaptv__.ads.vpaid.VPAIDEvent.AdClickThru", $c);
r("__adaptv__.ads.vpaid.VPAIDEvent.AdStopped", Vc);
r("__adaptv__.ads.vpaid.VPAIDEvent.AdError", Xc);
})();