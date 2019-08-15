    var Bookrack = function(a, b, c, e) {
        this.scale = e || 0.4;
        this.x = b || 120;
        this.y = c || 160;
        this.border =2;
        this.init(a);
        this.exec(Math.ceil(Math.random() * this.imgs.length))
    };
    Bookrack.prototype = {
        init: function(a) {
            this.width = a.clientWidth - 2 * this.x * this.scale;
            a.style.position = "relative";
            a.style.height = this.y + "px";
            this.imgs = a.getElementsByTagName("a");
            var b = this,
                c = document.createElement("span"),
                e,
                d;
            this.each(function(a, g) {
                a.style.position = "absolute";
                a.style.bottom = "0";
                a.style.border = this.border + "px solid gray";
                a.style.left = this.width * (g / this.imgs.length) + 2* this.border + "px";
                a.setAttribute("dir", g);
                d = a.getElementsByTagName("img")[0].getAttribute("alt").split("|");
                e = c.cloneNode(!0);
                e.innerHTML = a.getAttribute("title");
                a.appendChild(e);
                a.onmouseover = function() {
                    b.exec(this.getAttribute("dir"))
                }
            })
        },
        each: function(a) {
            for (var b = 0,
                     c; c = this.imgs[b++];) a.call(this, c, b, this.imgs.length)
        },
        color: function(a) {
            a = (~~ (255 * a)).toString(16);
            2 > a.length && (a = "0" + a);
            a = a.substr(0, 2);
            return "#" + a + a + a
        },
        exec: function(a) {
            this.each(function(b, c, e, d, f) {
                b.getElementsByTagName("span")[0].style.display = "none";
                c == a && (b.getElementsByTagName("span")[0].style.display = "block");
                d = Math.min(c / a, a / c);
                f = Math.sin(90 * (Math.PI / 180) * d) * (1 - this.scale);
                b.style.zIndex = Math.ceil(1E4 * f);
                b.style.borderColor = this.color(f + this.scale);
                b.style.width = this.x * (f + this.scale) - 2 * this.border + "px";
                b.style.height = this.y * (f + this.scale) - 2 * this.border + "px";
                b.style.marginLeft = this.x * f / -2 + "px"
            })
        }
    };
    new Bookrack(document.getElementById('bookrack'), 120, 160);

