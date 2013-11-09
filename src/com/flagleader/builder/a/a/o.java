package com.flagleader.builder.a.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.an;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class o extends an
  implements IElementViewer
{
  private static final int w = 0;
  private static final int x = 1;
  private static final int y = 2;
  private static final int z = 3;
  private static final int A = 4;
  public static int[] q = { 1, 2, 4 };
  public static String[] r = { "in", "inout", "out" };
  public static int[] s = { -7, -6, 5, 4, -5, 6, 7, 8, 2, 3, 1, 12, -1, 91, 92, 93, -2, -3, -4, 2004, 2005, 16 };
  public static String[] t = { "BIT", "TINYINT", "SMALLINT", "INTEGER", "BIGINT", "FLOAT", "REAL", "DOUBLE", "NUMERIC", "DECIMAL", "CHAR", "VARCHAR", "LONGVARCHAR", "DATE", "TIME", "TIMESTAMP", "BINARY", "VARBINARY", "LONGVARBINARY", "BLOB", "CLOB", "BOOLEAN" };
  public static String[] u = { "boolean", "short", "int", "int", "long", "float", "double", "double", "double", "double", "string", "string", "string", "date", "datatime", "datatime", "byte[]", "byte[]", "byte[]", "byte[]", "string", "boolean" };
  public static String[][] v = { { "boolean" }, { "short" }, { "short", "int" }, { "short", "int", "long" }, { "short", "int", "long" }, { "short", "int", "long", "float", "double" }, { "short", "int", "long", "float", "double" }, { "short", "int", "long", "float", "double" }, { "short", "int", "long", "float", "double" }, { "short", "int", "long", "float", "double", "decimal" }, { "string" }, { "string" }, { "string" }, { "date" }, { "date", "time", "datatime" }, { "date", "time", "datatime", "timestamp" }, { "byte[]" }, { "byte[]" }, { "byte[]" }, { "byte[]" }, { "string", "byte[]" }, { "boolean" } };
  private static final String B = "columns.ProcedureParameterView";

  public o(ProcedureModel paramProcedureModel, Composite paramComposite, bu parambu)
  {
    super(paramProcedureModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new o((ProcedureModel)this.c, paramComposite, this.a);
  }

  protected void i()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ProcedureParameterView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.ProcedureParameterView");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      TableColumn localTableColumn = new TableColumn(this.e, 8388608);
      localTableColumn.setText(ResourceTools.getMessage(arrayOfString1[i] + ".ProcedureParameterView"));
      localTableColumn.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
    this.e.setHeaderVisible(true);
  }

  protected void j()
  {
    super.j();
    this.e.addMouseListener(new r(this, null));
  }

  protected void a(ToolBar paramToolBar)
  {
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "copy");
    a(paramToolBar, "selectall");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    super.h();
  }

  private ProcedureModel q()
  {
    return (ProcedureModel)this.c;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    super.update();
  }

  protected void k()
  {
    for (int i = 0; i < q().getParas().size(); i++)
    {
      if (!(q().getParas().get(i) instanceof ParameterModel))
        continue;
      ParameterModel localParameterModel = (ParameterModel)q().getParas().get(i);
      TableItem localTableItem = new TableItem(this.e, 0);
      localTableItem.setText(new String[] { localParameterModel.getPos(), c(localParameterModel.getModetype()), a(localParameterModel.getIType()), localParameterModel.getValueType(), localParameterModel.getDisplayName() });
      localTableItem.setData(localParameterModel);
    }
  }

  protected void a(TableItem paramTableItem)
  {
    FieldModel localFieldModel = (FieldModel)paramTableItem.getData();
    paramTableItem.setText(3, localFieldModel.getValueType());
    paramTableItem.setText(4, localFieldModel.getDisplayName());
  }

  public String a(int paramInt)
  {
    for (int i = 0; i < s.length; i++)
      if (s[i] == paramInt)
        return t[i];
    return "NULL";
  }

  public String c(int paramInt)
  {
    for (int i = 0; i < q.length; i++)
      if (q[i] == paramInt)
        return r[i];
    return "UnKnow";
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "para";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.o
 * JD-Core Version:    0.6.0
 */