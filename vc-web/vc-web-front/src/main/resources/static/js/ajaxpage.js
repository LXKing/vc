$.fn.ajaxpage = function(page){
	var $this = $(this);
	var $thisName = $this.selector.substring(0,$this.selector.length);
	var url = page.url;
	var pagenumber = page.pagenumber;
	var totalpage =page.totalpage;
	var insertnode = page.insertnode;
	$this.html("");
	if (totalpage<=7)
	{
		$this.append("<div class='ajaxpage'>"+
						"<div class='ajaxpage_up'>上一页</div>"+
						"<div class='ajaxpage_down'>下一页</div>"+
					"</div>");
		for (var i = 1;i<=totalpage;i++)
		{
			$("<div class='ajaxpage_num'>"+i+"</div>").insertBefore($this.find(".ajaxpage_down"));
		}
		$this.find(".ajaxpage_num:first").addClass("ajaxpage_num_this");
		if (totalpage<2)
		{
			$(".ajaxpage_down").addClass("ajaxpage_down_over");	
		}
		$this.find(".ajaxpage_up").addClass("ajaxpage_up_over");
	}else{
		$this.append("<div class='ajaxpage'>"+
						"<div class='ajaxpage_up ajaxpage_up_over'>上一页</div>"+
						"<div class='ajaxpage_num ajaxpage_num_this'>1</div>"+
						"<div class='ajaxpage_num'>2</div>"+
						"<div class='ajaxpage_num'>3</div>"+
						"<div class='ajaxpage_num'>4</div>"+
						"<div class='ajaxpage_num'>5</div>"+
						"<div class='ajaxpage_num'>6</div>"+
						"<div class='ajaxpage_num'>7</div>"+
						"<div class='ajaxpage_ellipsis'>...</div>"+
						"<div class='ajaxpage_num'>"+totalpage+"</div>"+
						"<div class='ajaxpage_down'>下一页</div>"+
					"</div>");

	}
	$($thisName).find(".ajaxpage_num").click(function(){
		if(!$(this).hasClass("ajaxpage_num_this"))
		{
			insertnode(parseInt($(this).text()));
			judgepage(parseInt($(this).text()));
		}
	})
	$($thisName).find(".ajaxpage_up").click(function(){
		if (parseInt($this.find(".ajaxpage_num_this").text())-1>0)
		{
			insertnode(parseInt($this.find(".ajaxpage_num_this").text())-1);
			judgepage(parseInt($this.find(".ajaxpage_num_this").text())-1);	
		}
	});
	$($thisName).find(".ajaxpage_down").click(function(){
		if (parseInt($this.find(".ajaxpage_num_this").text())+1<=totalpage)
		{
			insertnode(parseInt($this.find(".ajaxpage_num_this").text())+1);
			judgepage(parseInt($this.find(".ajaxpage_num_this").text())+1);	
		}
	});
	var judgepage = function(thispage){
		if(totalpage<=7){
			if(thispage>1)
			{
				$(".ajaxpage_up").removeClass("ajaxpage_up_over");
			}else{
				$(".ajaxpage_up").addClass("ajaxpage_up_over");
			}
			if(thispage>=totalpage)
			{
				$(".ajaxpage_down").addClass("ajaxpage_down_over");
			}else{
				$(".ajaxpage_down").removeClass("ajaxpage_down_over");
			}
			$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
			$this.find(".ajaxpage_num").eq(thispage-1).addClass("ajaxpage_num_this");
		}else{
			if (thispage==1)
			{
				$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
				$this.find(".ajaxpage_num").eq(0).text(1).addClass("ajaxpage_num_this");
				$this.find(".ajaxpage_num").eq(1).text(2);
				$this.find(".ajaxpage_num").eq(2).text(3);
				$this.find(".ajaxpage_num").eq(3).text(4);
				$this.find(".ajaxpage_num").eq(4).text(5);
				$this.find(".ajaxpage_num").eq(5).text(6);
				$this.find(".ajaxpage_num").eq(6).text(7);	
				$this.find(".ajaxpage_up").addClass("ajaxpage_up_over");
				$this.find(".ajaxpage_down").removeClass("ajaxpage_down_over");
				$this.find(".ajaxpage_ellipsis").insertAfter($this.find(".ajaxpage_num").eq(6));
			}else if(thispage==2){
				$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
				$this.find(".ajaxpage_up").removeClass("ajaxpage_up_over");
				$this.find(".ajaxpage_down").removeClass("ajaxpage_down_over");
				$this.find(".ajaxpage_num").eq(0).text(1);
				$this.find(".ajaxpage_num").eq(1).text(2).addClass("ajaxpage_num_this");
				$this.find(".ajaxpage_num").eq(2).text(3);
				$this.find(".ajaxpage_num").eq(3).text(4);
				$this.find(".ajaxpage_num").eq(4).text(5);
				$this.find(".ajaxpage_num").eq(5).text(6);
				$this.find(".ajaxpage_num").eq(6).text(7);	
				$this.find(".ajaxpage_ellipsis").insertAfter($this.find(".ajaxpage_num").eq(6));
			}else if(thispage==3){
				$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
				$this.find(".ajaxpage_up").removeClass("ajaxpage_up_over");
				$this.find(".ajaxpage_num").eq(0).text(1);
				$this.find(".ajaxpage_num").eq(1).text(2);
				$this.find(".ajaxpage_num").eq(2).text(3).addClass("ajaxpage_num_this");
				$this.find(".ajaxpage_num").eq(3).text(4);
				$this.find(".ajaxpage_num").eq(4).text(5);
				$this.find(".ajaxpage_num").eq(5).text(6);
				$this.find(".ajaxpage_num").eq(6).text(7);
				$this.find(".ajaxpage_ellipsis").insertAfter($this.find(".ajaxpage_num").eq(6));
			}else if(thispage>3 && thispage<totalpage-8){
				$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
				$this.find(".ajaxpage_up").removeClass("ajaxpage_up_over");
				$this.find(".ajaxpage_down").removeClass("ajaxpage_down_over");
				$this.find(".ajaxpage_num").eq(0).text(thispage-3);
				$this.find(".ajaxpage_num").eq(1).text(thispage-2);
				$this.find(".ajaxpage_num").eq(2).text(thispage-1);
				$this.find(".ajaxpage_num").eq(3).text(thispage).addClass("ajaxpage_num_this");
				$this.find(".ajaxpage_num").eq(4).text(thispage+1);
				$this.find(".ajaxpage_num").eq(5).text(thispage+2);
				$this.find(".ajaxpage_num").eq(6).text(thispage+3);
				$this.find(".ajaxpage_ellipsis").insertAfter($this.find(".ajaxpage_num").eq(6));
			}else if(thispage==totalpage-8){
				$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
				$this.find(".ajaxpage_up").removeClass("ajaxpage_up_over");
				$this.find(".ajaxpage_down").removeClass("ajaxpage_down_over");
				$this.find(".ajaxpage_num").eq(0).text(totalpage-12);
				$this.find(".ajaxpage_num").eq(1).text(totalpage-11);
				$this.find(".ajaxpage_num").eq(2).text(totalpage-10);
				$this.find(".ajaxpage_num").eq(3).text(totalpage-9);
				$this.find(".ajaxpage_num").eq(4).text(totalpage-8).addClass("ajaxpage_num_this");
				$this.find(".ajaxpage_num").eq(5).text(totalpage-7);
				$this.find(".ajaxpage_num").eq(6).text(totalpage-6);
				$this.find(".ajaxpage_num").eq(7).text(totalpage);
				$this.find(".ajaxpage_ellipsis").insertAfter($this.find(".ajaxpage_num").eq(6));
			}else if(thispage==totalpage-7){
				$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
				$this.find(".ajaxpage_up").removeClass("ajaxpage_up_over");
				$this.find(".ajaxpage_down").removeClass("ajaxpage_down_over");
				$this.find(".ajaxpage_num").eq(0).text(totalpage-12);
				$this.find(".ajaxpage_num").eq(1).text(totalpage-11);
				$this.find(".ajaxpage_num").eq(2).text(totalpage-10);
				$this.find(".ajaxpage_num").eq(3).text(totalpage-9);
				$this.find(".ajaxpage_num").eq(4).text(totalpage-8);
				$this.find(".ajaxpage_num").eq(5).text(totalpage-7).addClass("ajaxpage_num_this");
				$this.find(".ajaxpage_num").eq(6).text(totalpage-6);
				$this.find(".ajaxpage_num").eq(7).text(totalpage);
				$this.find(".ajaxpage_ellipsis").insertAfter($this.find(".ajaxpage_num").eq(6));
			}else if(thispage == totalpage-6){
				$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
				$this.find(".ajaxpage_up").removeClass("ajaxpage_up_over");
				$this.find(".ajaxpage_down").removeClass("ajaxpage_down_over");
				$this.find(".ajaxpage_num").eq(0).text(1);
				$this.find(".ajaxpage_ellipsis").insertAfter($this.find(".ajaxpage_num").eq(0));
				$this.find(".ajaxpage_num").eq(1).text(totalpage-6).addClass("ajaxpage_num_this");
				$this.find(".ajaxpage_num").eq(2).text(totalpage-5);
				$this.find(".ajaxpage_num").eq(3).text(totalpage-4);
				$this.find(".ajaxpage_num").eq(4).text(totalpage-3);
				$this.find(".ajaxpage_num").eq(5).text(totalpage-2);
				$this.find(".ajaxpage_num").eq(6).text(totalpage-1);
				$this.find(".ajaxpage_num").eq(7).text(totalpage);
			}else if(thispage > totalpage-6){
				$this.find(".ajaxpage_num").removeClass("ajaxpage_num_this");
				$this.find(".ajaxpage_up").removeClass("ajaxpage_up_over");
				$this.find(".ajaxpage_down").removeClass("ajaxpage_down_over");
				$this.find(".ajaxpage_num").eq(0).text(1);
				$this.find(".ajaxpage_num").eq(1).text(totalpage-6);
				$this.find(".ajaxpage_num").eq(2).text(totalpage-5);
				$this.find(".ajaxpage_num").eq(3).text(totalpage-4);
				$this.find(".ajaxpage_num").eq(4).text(totalpage-3);
				$this.find(".ajaxpage_num").eq(5).text(totalpage-2);
				$this.find(".ajaxpage_num").eq(6).text(totalpage-1);
				$this.find(".ajaxpage_num").eq(7).text(totalpage);
				for (var a=0;a<8;a++)
				{
					if ($this.find(".ajaxpage_num").eq(a).text()==thispage)
					{
						$this.find(".ajaxpage_num").eq(a).addClass("ajaxpage_num_this");
						if (a==7)
						{
							$this.find(".ajaxpage_down").addClass("ajaxpage_down_over");
							$this.find(".ajaxpage_ellipsis").insertAfter($this.find(".ajaxpage_num").eq(0));
						}
					}
				}
			}
		}
	}
}