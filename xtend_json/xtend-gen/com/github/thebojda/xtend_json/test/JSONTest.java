package com.github.thebojda.xtend_json.test;

import com.github.thebojda.xtend_json.JSONExtension;
import com.github.thebojda.xtend_json.JSONExtension.JSONElement;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.json.JSONObject;

@SuppressWarnings("all")
public class JSONTest {
  public static void main(final String[] args) {
    try {
      Map<String,List<Map<String,String>>> _xsetliteral = null;
      Map<String,String> _xsetliteral_1 = null;
      Builder<String,String> _builder = ImmutableMap.builder();
      _builder.put("name", "xxx");
      _builder.put("address", "yyy");
      _xsetliteral_1 = _builder.build();
      Map<String,String> _xsetliteral_2 = null;
      Builder<String,String> _builder_1 = ImmutableMap.builder();
      _builder_1.put("name", "aaa");
      _builder_1.put("address", "bbb");
      _xsetliteral_2 = _builder_1.build();
      List<Map<String,String>> _xlistliteral = null;
      com.google.common.collect.ImmutableList.Builder<Map<String,String>> _builder_2 = ImmutableList.builder();
      _builder_2.add(_xsetliteral_1);
      _builder_2.add(_xsetliteral_2);
      _xlistliteral = _builder_2.build();
      Builder<String,List<Map<String,String>>> _builder_3 = ImmutableMap.builder();
      _builder_3.put("users", _xlistliteral);
      _xsetliteral = _builder_3.build();
      JSONObject _jSONObject = new JSONObject(_xsetliteral);
      JSONObject jo = _jSONObject;
      InputOutput.<JSONObject>println(jo);
      JSONElement _doubleGreaterThan = JSONExtension.operator_doubleGreaterThan(jo, "users");
      Map<String,String> _xsetliteral_3 = null;
      Builder<String,String> _builder_4 = ImmutableMap.builder();
      _builder_4.put("name", "foo");
      _builder_4.put("address", "bar");
      _xsetliteral_3 = _builder_4.build();
      JSONExtension.operator_tripleLessThan(_doubleGreaterThan, _xsetliteral_3);
      InputOutput.<JSONObject>println(jo);
      JSONElement _doubleGreaterThan_1 = JSONExtension.operator_doubleGreaterThan(jo, "users");
      final Procedure1<JSONElement> _function = new Procedure1<JSONElement>() {
          public void apply(final JSONElement it) {
            Object _tripleGreaterThan = JSONExtension.operator_tripleGreaterThan(it, "name");
            String _plus = ("name: " + _tripleGreaterThan);
            String _plus_1 = (_plus + " address: ");
            Object _tripleGreaterThan_1 = JSONExtension.operator_tripleGreaterThan(it, "address");
            String _plus_2 = (_plus_1 + _tripleGreaterThan_1);
            InputOutput.<String>println(_plus_2);
          }
        };
      IterableExtensions.<JSONElement>forEach(_doubleGreaterThan_1, _function);
      JSONElement _doubleGreaterThan_2 = JSONExtension.operator_doubleGreaterThan(jo, "users");
      JSONElement _doubleGreaterThan_3 = JSONExtension.operator_doubleGreaterThan(_doubleGreaterThan_2, 1);
      InputOutput.<JSONElement>println(_doubleGreaterThan_3);
      JSONElement _doubleGreaterThan_4 = JSONExtension.operator_doubleGreaterThan(jo, "users");
      JSONElement _doubleGreaterThan_5 = JSONExtension.operator_doubleGreaterThan(_doubleGreaterThan_4, 1);
      Map<String,String> _xsetliteral_4 = null;
      Builder<String,String> _builder_5 = ImmutableMap.builder();
      _builder_5.put("name", "fff");
      _builder_5.put("address", "ggg");
      _xsetliteral_4 = _builder_5.build();
      JSONExtension.operator_tripleLessThan(_doubleGreaterThan_5, _xsetliteral_4);
      InputOutput.<JSONObject>println(jo);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
