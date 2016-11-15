(function(){var l=this;function m(a){return void 0!==a}
function n(a){a=a.split(".");for(var b=l,c;c=a.shift();)if(null!=b[c])b=b[c];else return null;return b}
function p(a){var b=typeof a;if("object"==b)if(a){if(a instanceof Array)return"array";if(a instanceof Object)return b;var c=Object.prototype.toString.call(a);if("[object Window]"==c)return"object";if("[object Array]"==c||"number"==typeof a.length&&"undefined"!=typeof a.splice&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("splice"))return"array";if("[object Function]"==c||"undefined"!=typeof a.call&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("call"))return"function"}else return"null";
else if("function"==b&&"undefined"==typeof a.call)return"object";return b}
function q(a){return"array"==p(a)}
function t(a){return"string"==typeof a}
function u(a){return"function"==p(a)}
function aa(a){var b=typeof a;return"object"==b&&null!=a||"function"==b}
function ba(a,b,c){return a.call.apply(a.bind,arguments)}
function ca(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var c=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(c,d);return a.apply(b,c)}}return function(){return a.apply(b,arguments)}}
function da(a,b,c){da=Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?ba:ca;return da.apply(null,arguments)}
function v(a,b){var c=Array.prototype.slice.call(arguments,1);return function(){var b=c.slice();b.push.apply(b,arguments);return a.apply(this,b)}}
var ea=Date.now||function(){return+new Date};
function w(a,b){var c=a.split("."),d=l;c[0]in d||!d.execScript||d.execScript("var "+c[0]);for(var e;c.length&&(e=c.shift());)!c.length&&m(b)?d[e]=b:d[e]?d=d[e]:d=d[e]={}}
function x(a,b){function c(){}
c.prototype=b.prototype;a.u=b.prototype;a.prototype=new c;a.prototype.constructor=a;a.H=function(a,c,f){for(var g=Array(arguments.length-2),h=2;h<arguments.length;h++)g[h-2]=arguments[h];return b.prototype[c].apply(a,g)}}
;var y;var ga=String.prototype.trim?function(a){return a.trim()}:function(a){return a.replace(/^[\s\xa0]+|[\s\xa0]+$/g,"")},ha=/&/g,ia=/</g,ka=/>/g,la=/"/g,ma=/'/g,na=/\x00/g,oa=/[\x00&<>"']/;
function pa(a){var b=new RegExp("/".replace(/([-()\[\]{}+?*.$\^|,:#<!\\])/g,"\\$1").replace(/\x08/g,"\\x08"),"");return a.replace(b,"")}
function qa(a,b){return a<b?-1:a>b?1:0}
;var ra=Array.prototype.indexOf?function(a,b,c){return Array.prototype.indexOf.call(a,b,c)}:function(a,b,c){c=null==c?0:0>c?Math.max(0,a.length+c):c;
if(t(a))return t(b)&&1==b.length?a.indexOf(b,c):-1;for(;c<a.length;c++)if(c in a&&a[c]===b)return c;return-1},sa=Array.prototype.forEach?function(a,b,c){Array.prototype.forEach.call(a,b,c)}:function(a,b,c){for(var d=a.length,e=t(a)?a.split(""):a,f=0;f<d;f++)f in e&&b.call(c,e[f],f,a)},ta=Array.prototype.filter?function(a,b,c){return Array.prototype.filter.call(a,b,c)}:function(a,b,c){for(var d=a.length,e=[],f=0,g=t(a)?a.split(""):a,h=0;h<d;h++)if(h in g){var k=g[h];
b.call(c,k,h,a)&&(e[f++]=k)}return e},ua=Array.prototype.map?function(a,b,c){return Array.prototype.map.call(a,b,c)}:function(a,b,c){for(var d=a.length,e=Array(d),f=t(a)?a.split(""):a,g=0;g<d;g++)g in f&&(e[g]=b.call(c,f[g],g,a));
return e};function va(a){if(a.classList)return a.classList;a=a.className;return t(a)&&a.match(/\S+/g)||[]}
function wa(a){a.classList?a=a.classList.contains("playing"):(a=va(a),a=0<=ra(a,"playing"));return a}
function xa(){var a=document.body;a.classList?a.classList.add("playing"):wa(a)||(a.className+=0<a.className.length?" playing":"playing")}
function ya(){var a=document.body;a.classList?a.classList.remove("playing"):wa(a)&&(a.className=ta(va(a),function(a){return"playing"!=a}).join(" "))}
;function za(a,b,c){for(var d in a)b.call(c,a[d],d,a)}
function Aa(a,b){for(var c in a)if(b.call(void 0,a[c],c,a))return!0;return!1}
function Ba(a){var b=Ca,c;for(c in b)if(a.call(void 0,b[c],c,b))return c}
;var z;a:{var Da=l.navigator;if(Da){var Ea=Da.userAgent;if(Ea){z=Ea;break a}}z=""}function A(a){return-1!=z.indexOf(a)}
;function B(){this.a="";this.b=Ga}
B.prototype.w=!0;B.prototype.v=function(){return this.a};
function Ia(a){if(a instanceof B&&a.constructor===B&&a.b===Ga)return a.a;p(a);return"type_error:SafeUrl"}
var La=/^(?:(?:https?|mailto|ftp):|[^&:/?#]*(?:[/?#]|$))/i;function Ma(a){if(a instanceof B)return a;a=a.w?a.v():String(a);La.test(a)||(a="about:invalid#zClosurez");return Na(a)}
var Ga={};function Na(a){var b=new B;b.a=a;return b}
Na("about:blank");function C(){this.a="";this.b=Oa}
C.prototype.w=!0;C.prototype.v=function(){return this.a};
function Pa(a){if(a instanceof C&&a.constructor===C&&a.b===Oa)return a.a;p(a);return"type_error:SafeHtml"}
var Oa={};function Qa(a){var b=new C;b.a=a;return b}
Qa("<!DOCTYPE html>");Qa("");Qa("<br>");function D(a,b){this.x=m(a)?a:0;this.y=m(b)?b:0}
D.prototype.clone=function(){return new D(this.x,this.y)};
D.prototype.ceil=function(){this.x=Math.ceil(this.x);this.y=Math.ceil(this.y);return this};
D.prototype.floor=function(){this.x=Math.floor(this.x);this.y=Math.floor(this.y);return this};
D.prototype.round=function(){this.x=Math.round(this.x);this.y=Math.round(this.y);return this};function Ra(a){Ra[" "](a);return a}
Ra[" "]=function(){};
function Sa(a,b){try{return Ra(a[b]),!0}catch(c){}return!1}
function Ta(a,b){var c=Ua;return Object.prototype.hasOwnProperty.call(c,a)?c[a]:c[a]=b(a)}
;var Va=A("Opera"),E=A("Trident")||A("MSIE"),Wa=A("Edge"),Xa=Wa||E,F=A("Gecko")&&!(-1!=z.toLowerCase().indexOf("webkit")&&!A("Edge"))&&!(A("Trident")||A("MSIE"))&&!A("Edge"),Ya=-1!=z.toLowerCase().indexOf("webkit")&&!A("Edge");function Za(){var a=l.document;return a?a.documentMode:void 0}
var $a;a:{var ab="",bb=function(){var a=z;if(F)return/rv\:([^\);]+)(\)|;)/.exec(a);if(Wa)return/Edge\/([\d\.]+)/.exec(a);if(E)return/\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/.exec(a);if(Ya)return/WebKit\/(\S+)/.exec(a);if(Va)return/(?:Version)[ \/]?(\S+)/.exec(a)}();
bb&&(ab=bb?bb[1]:"");if(E){var cb=Za();if(null!=cb&&cb>parseFloat(ab)){$a=String(cb);break a}}$a=ab}var db=$a,Ua={};
function G(a){return Ta(a,function(){for(var b=0,c=ga(String(db)).split("."),d=ga(String(a)).split("."),e=Math.max(c.length,d.length),f=0;0==b&&f<e;f++){var g=c[f]||"",h=d[f]||"";do{g=/(\d*)(\D*)(.*)/.exec(g)||["","","",""];h=/(\d*)(\D*)(.*)/.exec(h)||["","","",""];if(0==g[0].length&&0==h[0].length)break;b=qa(0==g[1].length?0:parseInt(g[1],10),0==h[1].length?0:parseInt(h[1],10))||qa(0==g[2].length,0==h[2].length)||qa(g[2],h[2]);g=g[3];h=h[3]}while(0==b)}return 0<=b})}
var eb=l.document,fb=eb&&E?Za()||("CSS1Compat"==eb.compatMode?parseInt(db,10):5):void 0;!F&&!E||E&&9<=Number(fb)||F&&G("1.9.1");E&&G("9");function gb(a,b){var c;c=b instanceof B?b:Ma(b);a.href=Ia(c)}
;function ib(a){return 9==a.nodeType?a:a.ownerDocument||a.document}
function jb(a){return kb(a,function(a){if(a="A"==a.nodeName)a=!0;return a},void 0)}
function kb(a,b,c){for(var d=0;a&&(null==c||d<=c);){if(b(a))return a;a=a.parentNode;d++}return null}
function H(a){this.a=a||l.document||document}
H.prototype.createElement=function(a){return this.a.createElement(String(a))};
H.prototype.isElement=function(a){return aa(a)&&1==a.nodeType};
H.prototype.contains=function(a,b){if(!a||!b)return!1;if(a.contains&&1==b.nodeType)return a==b||a.contains(b);if("undefined"!=typeof a.compareDocumentPosition)return a==b||!!(a.compareDocumentPosition(b)&16);for(;b&&a!=b;)b=b.parentNode;return b==a};var lb=n("yt.dom.getNextId_");if(!lb){lb=function(){return++nb};
w("yt.dom.getNextId_",lb);var nb=0};var ob=window.yt&&window.yt.config_||window.ytcfg&&window.ytcfg.data_||{};w("yt.config_",ob);w("yt.tokens_",window.yt&&window.yt.tokens_||{});var pb=window.yt&&window.yt.msgs_||n("window.ytcfg.msgs")||{};w("yt.msgs_",pb);function qb(a){rb(ob,arguments)}
function I(a,b){return a in ob?ob[a]:b}
function sb(a){return a&&window.yterr?function(){try{return a.apply(this,arguments)}catch(d){var b=d,c=n("yt.logging.errors.log");c?c(b,void 0,void 0,void 0,void 0):(c=I("ERRORS",[]),c.push([b,void 0,void 0,void 0,void 0]),qb("ERRORS",c));throw d;}}:a}
function rb(a,b){if(1<b.length){var c=b[0];a[c]=b[1]}else{var d=b[0];for(c in d)a[c]=d[c]}}
;function J(a){this.type="";this.state=this.source=this.data=this.currentTarget=this.relatedTarget=this.target=null;this.charCode=this.keyCode=0;this.shiftKey=this.ctrlKey=this.altKey=!1;this.clientY=this.clientX=0;this.changedTouches=null;if(a=a||window.event){this.a=a;for(var b in a)b in tb||(this[b]=a[b]);(b=a.target||a.srcElement)&&3==b.nodeType&&(b=b.parentNode);this.target=b;if(b=a.relatedTarget)try{b=b.nodeName?b:null}catch(c){b=null}else"mouseover"==this.type?b=a.fromElement:"mouseout"==this.type&&
(b=a.toElement);this.relatedTarget=b;this.clientX=void 0!=a.clientX?a.clientX:a.pageX;this.clientY=void 0!=a.clientY?a.clientY:a.pageY;this.keyCode=a.keyCode?a.keyCode:a.which;this.charCode=a.charCode||("keypress"==this.type?this.keyCode:0);this.altKey=a.altKey;this.ctrlKey=a.ctrlKey;this.shiftKey=a.shiftKey}}
J.prototype.preventDefault=function(){this.a&&(this.a.returnValue=!1,this.a.preventDefault&&this.a.preventDefault())};
J.prototype.stopPropagation=function(){this.a&&(this.a.cancelBubble=!0,this.a.stopPropagation&&this.a.stopPropagation())};
J.prototype.stopImmediatePropagation=function(){this.a&&(this.a.cancelBubble=!0,this.a.stopImmediatePropagation&&this.a.stopImmediatePropagation())};
var tb={stopImmediatePropagation:1,stopPropagation:1,preventMouseEvent:1,preventManipulation:1,preventDefault:1,layerX:1,layerY:1,scale:1,rotation:1,webkitMovementX:1,webkitMovementY:1};var Ca=n("yt.events.listeners_")||{};w("yt.events.listeners_",Ca);var ub=n("yt.events.counter_")||{count:0};w("yt.events.counter_",ub);function vb(a,b,c,d){a.addEventListener&&("mouseenter"!=b||"onmouseenter"in document?"mouseleave"!=b||"onmouseenter"in document?"mousewheel"==b&&"MozBoxSizing"in document.documentElement.style&&(b="MozMousePixelScroll"):b="mouseout":b="mouseover");return Ba(function(e){return e[0]==a&&e[1]==b&&e[2]==c&&e[4]==!!d})}
function K(a,b,c,d){if(a&&(a.addEventListener||a.attachEvent)){d=!!d;var e=vb(a,b,c,d);if(!e){var e=++ub.count+"",f=!("mouseenter"!=b&&"mouseleave"!=b||!a.addEventListener||"onmouseenter"in document),g;g=f?function(d){d=new J(d);if(!kb(d.relatedTarget,function(b){return b==a}))return d.currentTarget=a,d.type=b,c.call(a,d)}:function(b){b=new J(b);
b.currentTarget=a;return c.call(a,b)};
g=sb(g);a.addEventListener?("mouseenter"==b&&f?b="mouseover":"mouseleave"==b&&f?b="mouseout":"mousewheel"==b&&"MozBoxSizing"in document.documentElement.style&&(b="MozMousePixelScroll"),a.addEventListener(b,g,d)):a.attachEvent("on"+b,g);Ca[e]=[a,b,c,g,d]}}}
;function wb(a){a=String(a);if(/^\s*$/.test(a)?0:/^[\],:{}\s\u2028\u2029]*$/.test(a.replace(/\\["\\\/bfnrtu]/g,"@").replace(/(?:"[^"\\\n\r\u2028\u2029\x00-\x08\x0a-\x1f]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)[\s\u2028\u2029]*(?=:|,|]|}|$)/g,"]").replace(/(?:^|:|,)(?:[\s\u2028\u2029]*\[)+/g,"")))try{return eval("("+a+")")}catch(b){}throw Error("Invalid JSON string: "+a);}
;function xb(){}
var yb="function"==typeof Uint8Array,zb=[];function N(a){var b=Ab;if(a<b.f){a+=b.g;var c=b.a[a];return c===zb?b.a[a]=[]:c}c=b.c[a];return c===zb?b.c[a]=[]:c}
function Bb(a){if(a.b)for(var b in a.b){var c=a.b[b];if(q(c))for(var d=0;d<c.length;d++)c[d]&&Bb(c[d]);else c&&Bb(c)}}
xb.prototype.toString=function(){Bb(this);return this.a.toString()};function Cb(a){this.b=null;a||(a=[]);this.g=-1;this.a=a;a:{if(this.a.length){a=this.a.length-1;var b=this.a[a];if(b&&"object"==typeof b&&!q(b)&&!(yb&&b instanceof Uint8Array)){this.f=a- -1;this.c=b;break a}}this.f=Number.MAX_VALUE}}
x(Cb,xb);var Db=/^(?:([^:/?#.]+):)?(?:\/\/(?:([^/?#]*)@)?([^/#?]*?)(?::([0-9]+))?(?=[/#?]|$))?([^?#]+)?(?:\?([^#]*))?(?:#(.*))?$/;function Eb(a){return a?decodeURI(a):a}
function Fb(a,b,c,d){for(var e=c.length;0<=(b=a.indexOf(c,b))&&b<d;){var f=a.charCodeAt(b-1);if(38==f||63==f)if(f=a.charCodeAt(b+e),!f||61==f||38==f||35==f)return b;b+=e+1}return-1}
var Gb=/#|$/,Hb=/[?&]($|#)/;function Ib(a,b){for(var c in a)Object.prototype.hasOwnProperty.call(a,c)&&b.call(void 0,a[c],c,a)}
function Jb(){var a=Kb;if(!a)return"";var b=/.*[&#?]google_debug(=[^&]*)?(&.*)?$/;try{var c=b.exec(decodeURIComponent(a));if(c)return c[1]&&1<c[1].length?c[1].substring(1):"true"}catch(d){}return""}
;function Lb(a,b){this.a=a;this.b=b}
function Mb(a,b){this.url=a;this.A=!!b;this.depth=null}
;function Nb(a,b,c){a.addEventListener?a.addEventListener(b,c,!1):a.attachEvent&&a.attachEvent("on"+b,c)}
;function Ob(a,b,c,d,e){this.h=c||4E3;this.c=a||"&";this.i=b||",$";this.f=m(d)?d:"trn";this.o=e||null;this.g=!1;this.b={};this.m=0;this.a=[]}
function Pb(a,b){var c={};c[a]=b;return[c]}
function O(a,b,c,d){a.a.push(b);a.b[b]=Pb(c,d)}
function Qb(a,b,c,d){b=b+"//"+c+d;var e=Rb(a)-d.length-0;if(0>e)return"";a.a.sort(function(a,b){return a-b});
d=null;c="";for(var f=0;f<a.a.length;f++)for(var g=a.a[f],h=a.b[g],k=0;k<h.length;k++){if(!e){d=null==d?g:d;break}var r=Sb(h[k],a.c,a.i);if(r){r=c+r;if(e>=r.length){e-=r.length;b+=r;c=a.c;break}else a.g&&(c=e,r[c-1]==a.c&&--c,b+=r.substr(0,c),c=a.c,e=0);d=null==d?g:d}}f="";a.f&&null!=d&&(f=c+a.f+"="+(a.o||d));return b+f+""}
function Rb(a){if(!a.f)return a.h;var b=1,c;for(c in a.b)b=c.length>b?c.length:b;return a.h-a.f.length-b-a.c.length-1}
function Sb(a,b,c,d,e){var f=[];Ib(a,function(a,h){var k=Tb(a,b,c,d,e);k&&f.push(h+"="+k)});
return f.join(b)}
function Tb(a,b,c,d,e){if(null==a)return"";b=b||"&";c=c||",$";"string"==typeof c&&(c=c.split(""));if(a instanceof Array){if(d=d||0,d<c.length){for(var f=[],g=0;g<a.length;g++)f.push(Tb(a[g],b,c,d+1,e));return f.join(c[d])}}else if("object"==typeof a)return e=e||0,2>e?encodeURIComponent(Sb(a,b,c,d,e+1)):"...";return encodeURIComponent(String(a))}
;function Ub(a,b,c,d,e,f){try{var g;c instanceof Ob?g=c:(g=new Ob,Ib(c,function(a,b){var c=g,d=c.m++,e=Pb(b,a);c.a.push(d);c.b[d]=e}));
if((d?a.c:Math.random())<(e||a.a)){var h=Qb(g,a.b,a.f,a.g+b+"&");"undefined"===typeof f?Vb(h):Vb(h,f)}}catch(k){}}
function Vb(a,b){l.google_image_requests||(l.google_image_requests=[]);var c=l.document.createElement("img");if(b){var d=function(a){b(a);a=d;c.removeEventListener?c.removeEventListener("load",a,!1):c.detachEvent&&c.detachEvent("onload",a);a=d;c.removeEventListener?c.removeEventListener("error",a,!1):c.detachEvent&&c.detachEvent("onerror",a)};
Nb(c,"load",d);Nb(c,"error",d)}c.src=a;l.google_image_requests.push(c)}
;function Wb(a,b,c){this.c=a;this.g=b;this.a=c;this.f=this.b}
function Xb(a,b,c){this.message=a;this.a=b||"";this.b=c||-1}
function Yb(a,b){var c;try{c=b()}catch(f){var d=a.a;try{var e=Zb(f),d=a.f.call(a,"osd_proto::reqm_int",e,void 0,void 0)}catch(g){a.b("pAR",g)}if(!d)throw f;}finally{}return c}
function $b(a){var b=ac;return function(){for(var c=[],d=0;d<arguments.length;++d)c[d]=arguments[d];return Yb(b,function(){return a.apply(void 0,c)})}}
Wb.prototype.b=function(a,b,c,d,e){try{var f=e||this.g,g=new Ob;g.g=!0;O(g,1,"context",a);b instanceof Xb||(b=Zb(b));O(g,2,"msg",b.message.substring(0,512));b.a&&O(g,3,"file",b.a);0<b.b&&O(g,4,"line",b.b.toString());b={};if(d)try{d(b)}catch(fa){}d=[b];g.a.push(5);g.b[5]=d;var h;e=l;d=[];var k,r=null;do{b=e;var Fa;try{Fa=!!b&&null!=b.location.href&&Sa(b,"foo")}catch(fa){Fa=!1}Fa?(k=b.location.href,r=b.document&&b.document.referrer||null):(k=r,r=null);d.push(new Mb(k||""));try{e=b.parent}catch(fa){e=
null}}while(e&&b!=e);k=0;for(var L=d.length-1;k<=L;++k)d[k].depth=L-k;b=l;if(b.location&&b.location.ancestorOrigins&&b.location.ancestorOrigins.length==d.length-1)for(k=1;k<d.length;++k){var Ha=d[k];Ha.url||(Ha.url=b.location.ancestorOrigins[k-1]||"",Ha.A=!0)}for(var Ja=new Mb(l.location.href,!1),Ka=d.length-1,L=Ka;0<=L;--L){var M=d[L];if(M.url&&!M.A){Ja=M;break}}var M=null,Pc=d.length&&d[Ka].url;0!=Ja.depth&&Pc&&(M=d[Ka]);h=new Lb(Ja,M);h.b&&O(g,6,"top",h.b.url||"");O(g,7,"url",h.a.url||"");Ub(this.c,
f,g,!1,c)}catch(fa){try{Ub(this.c,f,{context:"ecmserr",rctx:a,msg:bc(fa),url:h.a.url},!1,c)}catch(kd){}}return this.a};
function Zb(a){return new Xb(bc(a),a.fileName,a.lineNumber)}
function bc(a){var b=a.toString();a.name&&-1==b.indexOf(a.name)&&(b+=": "+a.name);a.message&&-1==b.indexOf(a.message)&&(b+=": "+a.message);if(a.stack){a=a.stack;var c=b;try{-1==a.indexOf(c)&&(a=c+"\n"+a);for(var d;a!=d;)d=a,a=a.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/,"$1");b=a.replace(/\n */g,"\n")}catch(e){b=c}}return b}
;var cc=document,P=window;var dc,ac;dc=new function(){this.b="http:"===P.location.protocol?"http:":"https:";this.f="pagead2.googlesyndication.com";this.g="/pagead/gen_204?id=";this.a=.01;this.c=Math.random()};
ac=new Wb(dc,"jserror",!0);function ec(a,b,c,d){if(d)c=a+("&"+b+"="+c);else{var e="&"+b+"=",f=a.indexOf(e);0>f?c=a+e+c:(f+=e.length,e=a.indexOf("&",f),c=0<=e?a.substring(0,f)+c+a.substring(e):a.substring(0,f)+c)}return 2E3<c.length?m(void 0)?ec(a,b,void 0,d):a:c}
;function fc(a,b){this.type=a;this.label=b}
function gc(a){}
function Q(a){m(void 0)||gc(a);new fc(a,1)}
function R(a){m(void 0)||gc(a);new fc(a,2)}
function S(a){new fc(a,3)}
Q("d");R("d");S("d");Q("f");R("f");S("f");Q("i");R("i");S("i");Q("j");R("j");S("j");Q("u");R("u");S("u");Q("v");R("v");S("v");Q("b");R("b");S("b");Q("e");R("e");S("e");Q("s");R("s");S("s");Q("B");R("B");S("B");Q("x");R("x");S("x");Q("y");R("y");S("y");Q("g");R("g");S("g");Q("h");R("h");S("h");Q("n");R("n");S("n");Q("o");R("o");S("o");function T(){this.c=this.c;this.a=this.a}
T.prototype.c=!1;T.prototype.isDisposed=function(){return this.c};
T.prototype.dispose=function(){this.c||(this.c=!0,this.i())};
T.prototype.i=function(){if(this.a)for(;this.a.length;)this.a.shift()()};
function hc(a){a&&"function"==typeof a.dispose&&a.dispose()}
;var ic=[0,2,1],jc=null;function kc(){var a=window.event||jc;if(!a)return null;var b;(b=a.which?1<<ic[a.which-1]:a.button)&&a.shiftKey&&(b|=8);b&&a.altKey&&(b|=16);b&&a.ctrlKey&&(b|=32);return b}
document.addEventListener&&document.addEventListener("mousedown",function(a){jc=a},!0);
window.mb=function(a){if(a){var b=kc();b&&(window.css?css(a.id,"mb",b,void 0,void 0):a&&(a.href=ec(a.href,"mb",b,void 0)))}};var lc=!E||9<=Number(fb),mc=E&&!G("9");!Ya||G("528");F&&G("1.9b")||E&&G("8")||Va&&G("9.5")||Ya&&G("528");F&&!G("8")||E&&G("9");function nc(a,b){this.type=a;this.currentTarget=this.target=b;this.defaultPrevented=this.b=!1}
nc.prototype.stopPropagation=function(){this.b=!0};
nc.prototype.preventDefault=function(){this.defaultPrevented=!0};function U(a,b){nc.call(this,a?a.type:"");this.relatedTarget=this.currentTarget=this.target=null;this.charCode=this.keyCode=this.button=this.screenY=this.screenX=this.clientY=this.clientX=0;this.metaKey=this.shiftKey=this.altKey=this.ctrlKey=!1;this.a=this.state=null;a&&this.init(a,b)}
x(U,nc);
U.prototype.init=function(a,b){var c=this.type=a.type,d=a.changedTouches?a.changedTouches[0]:null;this.target=a.target||a.srcElement;this.currentTarget=b;var e=a.relatedTarget;e?F&&(Sa(e,"nodeName")||(e=null)):"mouseover"==c?e=a.fromElement:"mouseout"==c&&(e=a.toElement);this.relatedTarget=e;null===d?(this.clientX=void 0!==a.clientX?a.clientX:a.pageX,this.clientY=void 0!==a.clientY?a.clientY:a.pageY,this.screenX=a.screenX||0,this.screenY=a.screenY||0):(this.clientX=void 0!==d.clientX?d.clientX:d.pageX,
this.clientY=void 0!==d.clientY?d.clientY:d.pageY,this.screenX=d.screenX||0,this.screenY=d.screenY||0);this.button=a.button;this.keyCode=a.keyCode||0;this.charCode=a.charCode||("keypress"==c?a.keyCode:0);this.ctrlKey=a.ctrlKey;this.altKey=a.altKey;this.shiftKey=a.shiftKey;this.metaKey=a.metaKey;this.state=a.state;this.a=a;a.defaultPrevented&&this.preventDefault()};
U.prototype.stopPropagation=function(){U.u.stopPropagation.call(this);this.a.stopPropagation?this.a.stopPropagation():this.a.cancelBubble=!0};
U.prototype.preventDefault=function(){U.u.preventDefault.call(this);var a=this.a;if(a.preventDefault)a.preventDefault();else if(a.returnValue=!1,mc)try{if(a.ctrlKey||112<=a.keyCode&&123>=a.keyCode)a.keyCode=-1}catch(b){}};var oc="closure_listenable_"+(1E6*Math.random()|0),pc=0;function qc(a,b,c,d,e){this.listener=a;this.a=null;this.src=b;this.type=c;this.l=!!d;this.b=e;this.key=++pc;this.j=this.s=!1}
function rc(a){a.j=!0;a.listener=null;a.a=null;a.src=null;a.b=null}
;function sc(a){this.src=a;this.a={};this.b=0}
sc.prototype.remove=function(a,b,c,d){a=a.toString();if(!(a in this.a))return!1;var e=this.a[a];b=tc(e,b,c,d);return-1<b?(rc(e[b]),Array.prototype.splice.call(e,b,1),0==e.length&&(delete this.a[a],this.b--),!0):!1};
sc.prototype.hasListener=function(a,b){var c=m(a),d=c?a.toString():"",e=m(b);return Aa(this.a,function(a){for(var g=0;g<a.length;++g)if(!(c&&a[g].type!=d||e&&a[g].l!=b))return!0;return!1})};
function tc(a,b,c,d){for(var e=0;e<a.length;++e){var f=a[e];if(!f.j&&f.listener==b&&f.l==!!c&&f.b==d)return e}return-1}
;var uc="closure_lm_"+(1E6*Math.random()|0),vc={},wc=0;
function xc(a,b,c,d,e){if(q(b)){for(var f=0;f<b.length;f++)xc(a,b[f],c,d,e);return null}c=yc(c);if(a&&a[oc])a=zc(a,b,c,d,e);else{f=c;if(!b)throw Error("Invalid event type");c=!!d;var g=Ac(a);g||(a[uc]=g=new sc(a));var h=g,k=b.toString(),g=h.a[k];g||(g=h.a[k]=[],h.b++);var r=tc(g,f,d,e);-1<r?(d=g[r],d.s=!1):(d=new qc(f,h.src,k,!!d,e),d.s=!1,g.push(d));if(!d.a){e=Bc();d.a=e;e.src=a;e.listener=d;if(a.addEventListener)a.addEventListener(b.toString(),e,c);else if(a.attachEvent)a.attachEvent(Cc(b.toString()),
e);else throw Error("addEventListener and attachEvent are unavailable.");wc++}a=d}return a}
function Bc(){var a=Dc,b=lc?function(c){return a.call(b.src,b.listener,c)}:function(c){c=a.call(b.src,b.listener,c);
if(!c)return c};
return b}
function Ec(a){if("number"!=typeof a&&a&&!a.j){var b=a.src;if(b&&b[oc])b.a(a);else{var c=a.type,d=a.a;b.removeEventListener?b.removeEventListener(c,d,a.l):b.detachEvent&&b.detachEvent(Cc(c),d);wc--;if(c=Ac(b)){var d=a.type,e;if(e=d in c.a){e=c.a[d];var f=ra(e,a),g;(g=0<=f)&&Array.prototype.splice.call(e,f,1);e=g}e&&(rc(a),0==c.a[d].length&&(delete c.a[d],c.b--));0==c.b&&(c.src=null,b[uc]=null)}else rc(a)}}}
function Cc(a){return a in vc?vc[a]:vc[a]="on"+a}
function Fc(a,b,c,d){var e=!0;if(a=Ac(a))if(b=a.a[b.toString()])for(b=b.concat(),a=0;a<b.length;a++){var f=b[a];f&&f.l==c&&!f.j&&(f=Gc(f,d),e=e&&!1!==f)}return e}
function Gc(a,b){var c=a.listener,d=a.b||a.src;a.s&&Ec(a);return c.call(d,b)}
function Dc(a,b){if(a.j)return!0;if(!lc){var c=b||n("window.event"),d=new U(c,this),e=!0;if(!(0>c.keyCode||void 0!=c.returnValue)){a:{var f=!1;if(0==c.keyCode)try{c.keyCode=-1;break a}catch(k){f=!0}if(f||void 0==c.returnValue)c.returnValue=!0}c=[];for(f=d.currentTarget;f;f=f.parentNode)c.push(f);for(var f=a.type,g=c.length-1;!d.b&&0<=g;g--){d.currentTarget=c[g];var h=Fc(c[g],f,!0,d),e=e&&h}for(g=0;!d.b&&g<c.length;g++)d.currentTarget=c[g],h=Fc(c[g],f,!1,d),e=e&&h}return e}return Gc(a,new U(b,this))}
function Ac(a){a=a[uc];return a instanceof sc?a:null}
var Hc="__closure_events_fn_"+(1E9*Math.random()>>>0);function yc(a){if(u(a))return a;a[Hc]||(a[Hc]=function(b){return a.handleEvent(b)});
return a[Hc]}
;function V(a){T.call(this);this.f=a;this.b={}}
x(V,T);var Ic=[];function zc(a,b,c,d,e){q(c)||(c&&(Ic[0]=c.toString()),c=Ic);for(var f=0;f<c.length;f++){var g=xc(b,c[f],d||a.handleEvent,e||!1,a.f||a);if(!g)break;a.b[g.key]=g}return a}
function Jc(a){za(a.b,function(a,c){this.b.hasOwnProperty(c)&&Ec(a)},a);
a.b={}}
V.prototype.i=function(){V.u.i.call(this);Jc(this)};
V.prototype.handleEvent=function(){throw Error("EventHandler.handleEvent not implemented");};function W(a,b,c){T.call(this);this.f=a;this.m=b;this.C=c;this.h=0;this.b={};this.g=new V(this);a=v(hc,this.g);this.c?m(void 0)?a.call(void 0):a():(this.a||(this.a=[]),this.a.push(m(void 0)?da(a,void 0):a));Kc(this)}
x(W,T);function Kc(a){sa(a.C,function(a){zc(this.g,a.element,"mousedown",this.D,!0);zc(this.g,a.element,"mouseup",v(this.G,a),!0)},a);
zc(a.g,a.m,"mouseenter",a.F,void 0)}
function Lc(a,b){za(a.b,function(a,d){for(var e=b,f=e.search(Gb),g=0,h,k=[];0<=(h=Fb(e,g,d,f));)k.push(e.substring(g,h)),g=Math.min(e.indexOf("&",h)+1||f,f);k.push(e.substr(g));e=[k.join("").replace(Hb,"$1"),"&",d];null!=a&&e.push("=",encodeURIComponent(String(a)));e[1]&&(f=e[0],g=f.indexOf("#"),0<=g&&(e.push(f.substr(g)),e[0]=f=f.substr(0,g)),g=f.indexOf("?"),0>g?e[1]="?":g==f.length-1&&(e[1]=void 0));b=e.join("")});
return b}
W.prototype.D=function(){this.o=ea()};
W.prototype.G=function(a,b){var c=a.element;1==(this.f&1)&&(0==this.h&&this.h++,this.b.nm=this.h);2==(this.f&2)&&(this.b.nb=a.B);if(8==(this.f&8)){var d=this.m,e=ib(d),f=new D(0,0),g;g=e?ib(e):document;g=!E||9<=Number(fb)||"CSS1Compat"==(g?new H(ib(g)):y||(y=new H)).a.compatMode?g.documentElement:g.body;if(d!=g){var h;b:{try{h=d.getBoundingClientRect()}catch(k){h={left:0,top:0,right:0,bottom:0};break b}E&&d.ownerDocument.body&&(d=d.ownerDocument,h.left-=d.documentElement.clientLeft+d.body.clientLeft,
h.top-=d.documentElement.clientTop+d.body.clientTop)}d=(e?new H(ib(e)):y||(y=new H)).a;e=d.scrollingElement?d.scrollingElement:Ya||"CSS1Compat"!=d.compatMode?d.body||d.documentElement:d.documentElement;d=d.parentWindow||d.defaultView;e=E&&G("10")&&d.pageYOffset!=e.scrollTop?new D(e.scrollLeft,e.scrollTop):new D(d.pageXOffset||e.scrollLeft,d.pageYOffset||e.scrollTop);f.x=h.left+e.x;f.y=h.top+e.y}this.b.nx=Math.round(b.clientX-f.x);this.b.ny=Math.round(b.clientY-f.y)}16==(this.f&16)&&null!=this.o&&
(f=ea()-this.o,this.b.clkt=f);512==(this.f&512)&&(f=kc())&&(this.b.mb=f);"A"==c.tagName.toUpperCase()&&gb(c,Lc(this,c.href))};
W.prototype.F=function(){this.h++};if(cc&&cc.URL){var Kb=cc.URL,Mc=!(Kb&&0<Jb().length);ac.a=Mc};function Nc(a,b){this.b=a||0;this.a=b||""}
Nc.prototype.match=function(a){return(this.b||this.a)&&(a.b||a.a)?this.a||a.a?this.a==a.a:this.b||a.b?this.b==a.b:!1:!1};
Nc.prototype.toString=function(){var a=""+this.b;this.a&&(a+="-"+this.a);return a};
function Oc(a){var b=[];za(a,function(a,d){var e=encodeURIComponent(d),f=a;t(f)&&(f=encodeURIComponent(f));b.push(e+"="+f)});
b.push("24="+(new Date).getTime());return b.join("\n")}
var Qc=0,Rc=0;function Sc(){var a=0,b=P;try{if(b&&b.Goog_AdSense_getAdAdapterInstance)return b}catch(d){}var c=b.location&&b.location.ancestorOrigins;if(m(c)&&(!c||!c.length))return null;for(;b&&5>a;){try{if(b.google_osd_static_frame)return b}catch(d){}try{if(b.aswift_0&&b.aswift_0.google_osd_static_frame)return b.aswift_0}catch(d){}a++;b=b!=b.parent?b.parent:null}return null}
function Tc(a,b,c,d,e){if(10<Rc)P.clearInterval(Qc);else if(++Rc,P.postMessage&&(b.b||b.a)){var f=Sc();if(f){var g={};b.b&&(g[4]=b.b);b.a&&(g[12]=b.a);g[0]="goog_request_monitoring";g[6]=a;g[16]=c;d&&d.length&&(g[17]=d.join(","));e&&(g[19]=e);try{var h=Oc(g);f.postMessage(h,"*")}catch(k){}}}}
;function Uc(a,b,c){if(c.data){var d=c.data;if(t(d)){c={};for(var d=d.split("\n"),e=0;e<d.length;e++){var f=d[e].indexOf("=");if(!(0>=f)){var g=Number(d[e].substr(0,f)),f=d[e].substr(f+1);switch(g){case 5:case 8:case 11:case 15:case 16:case 18:f="true"==f;break;case 4:case 7:case 6:case 14:case 20:case 21:case 22:case 23:case 24:f=Number(f);break;case 3:case 19:if(u(decodeURIComponent))try{f=decodeURIComponent(f)}catch(h){throw Error("Error: URI malformed: "+f);}break;case 17:f=ua(decodeURIComponent(f).split(","),
Number)}c[g]=f}}c=c[0]?c:null}else c=null;c&&(d=new Nc(c[4],c[12]),a&&a.match(d)&&"goog_update_data"==c[0]&&(a=c[7],"number"==typeof a&&b(a)))}}
;var Vc={"pyv-embed":2,"pyv-embed-container":2,"pyv-embed-channel-image-overlay":19,"pyv-embed-channel-name-overlay":20,"pyv-embed-channel-banner-overlay":9,"pyv-embed-overlay":21,"pyv-embed-headline-overlay":0,"pyv-embed-description-overlay":7},Wc=!1,Xc=!1,X=null,Ab=new Cb,Y=null,Yc=!1,Zc=null,$c=null;function ad(){var a=0;Z("osd-1")?a=.01:Z("osd-25")?a=.25:Z("osd-50")?a=.5:Z("osd-75")&&(a=.75);null!=$c&&Yc&&!Wc&&($c>=a?Y.playVideo():Y.pauseVideo())}
function bd(){var a=15E3-1E3*Y.getCurrentTime();return 0<=a?a:0}
function cd(){Y.mute();Z("osd")?(Yc=!0,ad()):Y.playVideo()}
function dd(a){if(Z("osd"))switch(a.data){case YT.PlayerState.PLAYING:null===X&&(0==bd()?ed():(xa(),X=l.setTimeout(ed,bd())));break;case YT.PlayerState.PAUSED:null!=X&&(l.clearTimeout(X),X=null);0==bd()&&ed();break;case YT.PlayerState.ENDED:ya(),Wc=!0}else switch(a.data){case YT.PlayerState.PLAYING:Xc||(xa(),l.setTimeout(ed,15E3),Xc=!0);break;case YT.PlayerState.ENDED:ya()}}
function ed(){ya();Wc=!0;Y.stopVideo()}
function fd(){var a=I("PLAYER_CONFIG",void 0),b=I("VIDEO_ID",void 0),c=I("HOST",void 0);aa(a)&&t(b)&&aa(YT)&&u(YT.ready)&&u(YT.Player)&&YT.ready(function(){var d={height:"100%",width:"100%",videoId:b,playerVars:a,events:{onReady:cd,onStateChange:dd}};t(c)&&(d.host=c);Y=new YT.Player("iframe-player",d)})}
function gd(a){$c=a;null===Y?fd():ad()}
function hd(){var a=N(1);Eb(a.match(Db)[3]||null)||(0==a.lastIndexOf("/",0)&&(a=pa(a)),a="https://googleads.g.doubleclick.net/"+a);var b=[],c=0;null!=N(2)&&(c=N(2));za(Vc,function(c,e){var f;f=document;if((f=t(e)?f.getElementById(e):e)&&(Z("background_click")||document.body.id!=e)&&(Z("container_click")||"pyv-embed-container"!=e)){var g=Z("background_click")||Z("container_click");"a"==f.nodeName.toLowerCase()?(gb(f,a),g||K(f,"click",id,!0)):(K(f,"click",v(jd,a)),K(f,"click",id,!0));b.push({element:f,
B:c})}});
document.body&&!Z("dss")&&(Zc=new W(c,document.body,b))}
function Z(a){var b=I("RENDERING_EXPERIMENTS")||[];return q(b)&&0<=ra(b,a)}
function jd(a,b){var c;c=b||window.event;c=c.target||c.srcElement;3==c.nodeType&&(c=c.parentNode);if(a&&c&&!jb(c)){c=b||window.event;c.cancelBubble=!0;c.stopPropagation&&c.stopPropagation();null!=Zc&&(a=Lc(Zc,a));var d=a,e={target:"_blank"};c=window;var f;f=d instanceof B?d:Ma("undefined"!=typeof d.href?d.href:String(d));var d=e.target||d.target,g=[],h;for(h in e)switch(h){case "width":case "height":case "top":case "left":g.push(h+"="+e[h]);break;case "target":case "noreferrer":break;default:g.push(h+
"="+(e[h]?1:0))}h=g.join(",");(A("iPhone")&&!A("iPod")&&!A("iPad")||A("iPad")||A("iPod"))&&c.navigator&&c.navigator.standalone&&d&&"_self"!=d?(h=c.document.createElement("A"),gb(h,f),h.setAttribute("target",d),e.noreferrer&&h.setAttribute("rel","noreferrer"),f=document.createEvent("MouseEvent"),f.initMouseEvent("click",!0,!0,c,1),h.dispatchEvent(f)):e.noreferrer?(h=c.open("",d,h),c=Ia(f),h&&(Xa&&-1!=c.indexOf(";")&&(c="'"+c.replace(/'/g,"%27")+"'"),h.opener=null,oa.test(c)&&(-1!=c.indexOf("&")&&(c=
c.replace(ha,"&amp;")),-1!=c.indexOf("<")&&(c=c.replace(ia,"&lt;")),-1!=c.indexOf(">")&&(c=c.replace(ka,"&gt;")),-1!=c.indexOf('"')&&(c=c.replace(la,"&quot;")),-1!=c.indexOf("'")&&(c=c.replace(ma,"&#39;")),-1!=c.indexOf("\x00")&&(c=c.replace(na,"&#0;"))),c=Qa('<META HTTP-EQUIV="refresh" content="0; url='+c+'">'),h.document.write(Pa(c)),h.document.close())):c.open(Ia(f),d,h)}}
function id(){Ub(dc,"pyv_user_click",{},!0,.1,void 0)}
;w("yt.setConfig",qb);w("yt.setMsg",function(a){rb(pb,arguments)});
K(window,"load",function(){Z("osd")||fd()});
K(window,"message",function(a){try{var b=wb(a.data)}catch(c){return}q(b)&&(Ab=new Cb(b),null!=N(1)&&(hd(),Z("osd")&&null!=N(3)&&(a=window,b=N(3),b=new Nc(b,null),b.b||b.a)))&&(Nb(a,"message",v(Uc,b,gd)),Qc=P.setInterval($b(v(Tc,2,b,void 0,void 0,void 0)),500))});})();
