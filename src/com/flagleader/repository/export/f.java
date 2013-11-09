package com.flagleader.repository.export;

public class f extends d
{
  protected void e()
  {
    if (m().length() > 0)
      this.d.append("package " + m() + ";").append(a);
    this.d.append("import java.io.*;").append(a);
    this.d.append("import com.flagleader.export.* ;").append(a);
    this.d.append("import com.flagleader.util.*;").append(a);
    this.d.append("import java.util.* ;").append(a);
    c();
    this.d.append("public class " + i() + " extends PageExportAction {").append(a);
    this.d.append("\tpublic " + i() + "() {").append(a);
    this.d.append("\t\tsuper();").append(a);
    this.d.append("\t}").append(a);
    this.d.append("\tpublic " + i() + "(PrintWriter writer) {").append(a);
    this.d.append("\t\tsuper(writer);").append(a);
    this.d.append("\t}").append(a);
    this.d.append("\tpublic " + i() + "(PrintWriter writer, boolean autoFlash) {").append(a);
    this.d.append("\t\tsuper(writer, autoFlash);").append(a);
    this.d.append("\t}").append(a);
    this.d.append("\tprotected void export() {").append(a);
  }

  protected void f()
  {
    this.d.append("\t}").append(a);
    b();
    a();
    this.d.append("}").append(a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.f
 * JD-Core Version:    0.6.0
 */