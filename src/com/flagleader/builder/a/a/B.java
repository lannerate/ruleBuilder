package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.an;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class B extends an
  implements IElementViewer
{
  private static final int q = 3;
  private static final int r = 6;
  private static final String s = "columns.SelectFieldView";

  public B(ISelectObject paramISelectObject, Composite paramComposite, bu parambu)
  {
    super(paramISelectObject, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new B((ISelectObject)this.c, paramComposite, this.a);
  }

  protected void j()
  {
    super.j();
    this.e.addMouseListener(new C(this, null));
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
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
    a(new H(this));
    super.h();
  }

  protected void q()
  {
    try
    {
      if (r().refresh())
        update();
    }
    catch (Exception localException)
    {
      a().showError(localException.getLocalizedMessage());
    }
  }

  private ISelectObject r()
  {
    return (ISelectObject)this.c;
  }

  protected void k()
  {
    for (int i = 0; i < r().getFields().size(); i++)
    {
      if (!(r().getFields().get(i) instanceof FieldModel))
        continue;
      FieldModel localFieldModel = (FieldModel)r().getFields().get(i);
      TableItem localTableItem = new TableItem(this.e, 0);
      localTableItem.setText(new String[] { i, localFieldModel.getFieldName(), localFieldModel.getFieldType(), localFieldModel.getValueType(), localFieldModel.getLen(), a(localFieldModel), localFieldModel.getDisplayName() });
      localTableItem.setData(localFieldModel);
    }
  }

  protected void a(TableItem paramTableItem)
  {
    FieldModel localFieldModel = (FieldModel)paramTableItem.getData();
    paramTableItem.setText(3, localFieldModel.getValueType());
    paramTableItem.setText(6, localFieldModel.getDisplayName());
  }

  protected void i()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SelectFieldView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.SelectFieldView");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      TableColumn localTableColumn = new TableColumn(this.e, 8388608);
      localTableColumn.setText(ResourceTools.getMessage(arrayOfString1[i] + ".SelectFieldView"));
      localTableColumn.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
    this.e.setHeaderVisible(true);
  }

  private String a(FieldModel paramFieldModel)
  {
    if (paramFieldModel.isUnNull())
      return ResourceTools.getMessage("notnull.TEXT");
    return ResourceTools.getMessage("null.TEXT");
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "field";
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean isCanSelectAll()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.B
 * JD-Core Version:    0.6.0
 */