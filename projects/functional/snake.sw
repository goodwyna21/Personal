BEGIN(args)=loop({`dir`:1,`cont`:1,`snake`:{`len`:1,`x`:111,`y`:111,`color`:{`r`:11111111,`g`:0,`b`:11111111},`window`:{`width`:1111,`height`:1111,`color`:{`r`:0,`g`:11111111,`b`:0}}})
//
loop(params)=(eq(get(params,`cont`),1))>loop(game(params))<0
//
attach(a,b)=b
//
move(params,cnt:=0)=eq(cnt,100)>params<eq(cnt,get(params,`dir`))>attach(set(get(params,`snake`),get([`x`,`y`],get_sym(params)),eq(get_inc(params),1)>inc(get(params,`snake`),get([`x`,`y`],get_sym(params)))<dec(get(params,`snake`),get([`x`,`y`],get_sym(params)))),params)<move(params,inc(cnt))
//
get_sym(params)=eq(get(get(params,`dir`),0),1)>`x`<`y`;
//
get_inc(params)=eq({get(get(params,`dir`),0)}∩{get(get(params,`dir`),1)},{})>1<0
//
update(params)=move(new_dir(params))
//
inc_wrap(a)=gt(inc(a),11)>0<inc(a)
//
dec_wrap(a)=eq(a,00)>11<dec(a)
//
new_dir(params)=attach(set(params,`dir`,new_dir(params,[get(INPUT,`UPARROW`),get(INPUT,`RIGHTARROW`),get(INPUT,`DOWNARROW`),get(INPUT,`LEFTARROW`)],0)),params)
//
new_dir(params,keys,cnt)=(eq(cnt,11))>{}<{({eq(get(params,`dir`),cnt)}∩{get(keys,inc_wrap(cnt))}={1})>inc_wrap(cnt)}Unew_dir(params,keys,inc(cnt))
//
check_wall(params,x:=get(get(params,`snake`)),y:=get(get(params,`snake`),`y`))=eq({eq(x,0)}U{eq(x,10000)}U{eq(y,0)}U{eq(y,10000)},{1})>attach(set(params,`cont`,0),params)<params
//
gen_table(params,y:=0)=eq(y,10000)>[]<[gen_row(params,y)]Ugen_table(params,inc(y))
//
gen_row(params,y,x:=0)=eq(x,10000)>[]<[eq({eq(x,get(get(params,`snake`),`x`))}∩{eq(x,get(get(params,`snake`),`x`))})]Ugen_row(params,y,inc(x))
//
game(params)=attach(DISPLAY(gen_table(check_wall(update(params))),get(params,`window`)),params)
//