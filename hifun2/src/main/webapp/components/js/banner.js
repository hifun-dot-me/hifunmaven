var hifun = {}, H$ = function(id){return document.getElementById(id)}, H$$ = function(c,p){return p.getElementsByTagName(c);}
hifun.slider = function(){
	return{
		init:function(id,options){
			var ul = this.u = H$$('ul',H$(id))[0], li = H$$('li',ul); this.l=li.length; this.index = 0;
			if(options.navId&&options.curClass){this.nav = H$$('li',H$(options.navId)), this.c = options.curClass;}
			this.a=options.auto||0; this.v=options.vertical||0;H$(id).style.overflow = 'hidden';H$(id).style.position = 'relative';ul.style.position='absolute';
			if(this.v){ul.style.top=0; this.h=options.height||li[0].offsetHeight; ul.style.height=(this.l*this.h)+'px';}
			else{ul.style.left=0; this.w=options.width||li[0].offsetWidth; ul.style.width=(this.l*this.w)+'px';}
			this.pos(options.index||0,this.a?1:0);
		},
		
		pos:function(pos,a){
			clearInterval(this.u.posAnim); clearInterval(this.u.auto);
			var curPos=this.v?parseInt(this.u.style.top):parseInt(this.u.style.left),
			correctPos=this.v?pos*this.h:pos*this.w, 
			direction = correctPos>Math.abs(curPos)?1:-1;
			correctPos*=-1; 
			this.index = pos;
			if(this.nav){for(var i=0;i<this.l;i++){this.nav[i].className = i==pos?this.c:''}}
			this.u.posAnim = setInterval(function(){hifun.slider.anim(correctPos,direction,a)},10);
		},
		
		anim:function(des,dir,a){
			var curPos=this.v?parseInt(this.u.style.top):parseInt(this.u.style.left);
			if(curPos == des){
				clearInterval(this.u.posAnim);
				if(a||this.a){hifun.slider.auto()}
			}
			else{
				var v=curPos-Math.ceil(Math.abs(des-curPos)*.07)*dir+'px';
				this.v?this.u.style.top=v:this.u.style.left=v;
			}
		},
		
		auto:function(){
			this.u.auto=setInterval(function(){hifun.slider.move(1,1)},this.a*1000)
		},
		
		move:function(n,a){
			var num=this.index+n, i=n==1?num==this.l?0:num:num<0?this.l-1:num; hifun.slider.pos(i,a);
		}
	};
}();
$(document).ready(function(){
	hifun.slider.init('slider',{	
		auto:3,
		vertical:1,
		navId:'nav',
		curClass:'nav',
		index:0});
});