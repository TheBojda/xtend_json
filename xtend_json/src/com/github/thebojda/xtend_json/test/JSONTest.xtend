package com.github.thebojda.xtend_json.test

import org.json.JSONObject

import static extension com.github.thebojda.xtend_json.JSONExtension.*;

class JSONTest {
	
	 def static void main(String[] args) {
    	var jo = new JSONObject(#{'users' -> #[
    		#{'name' -> 'xxx', 'address' -> 'yyy'},
    		#{'name' -> 'aaa', 'address' -> 'bbb'}    		
    	]});
    	println(jo);
    	
    	jo >> 'users' <<< #{'name' -> 'foo', 'address' -> 'bar'};
    	println(jo);
    	
    	(jo >> 'users').forEach[
    		println('name: ' + (it >>> 'name') + ' address: ' + (it >>> 'address'));
    	];
    	
    	println(jo >> 'users' >> 1);
    	
    	jo >> 'users' >> 1 <<< #{'name' -> 'fff', 'address' -> 'ggg'};
    	
    	println(jo);
  	}
  	
}