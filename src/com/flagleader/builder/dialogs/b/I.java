package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.MethodParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class I extends f
{
  private SelectTable a = null;
  private HashMap b = new HashMap();
  private List c = null;
  private List d = new ArrayList();

  public I(SelectTable paramSelectTable)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramSelectTable;
    this.c = this.a.getTableFunction("selectWhere").getAllParams();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(b("title.SelectWhereValueDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(300, this.c.size() * 27 + 30));
    getShell().setCursor(getShell().getDisplay().getSystemCursor(1));
    for (int i = 0; i < this.c.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.c.get(i);
      String str = this.a.getParamDisplay("arg" + (i + 1));
      if (str.length() > 0)
        a(localComposite2).setText(str);
      else
        a(localComposite2).setText(b("field.SelectWhereValueDialog") + (i + 1) + "(" + localMethodParam.getTypeName() + "):  ");
      Text localText = super.b(localComposite2, 2048, 200, 15);
      this.b.put(localMethodParam, localText);
      Object localObject = this.a.getOldInputs().get(String.valueOf(i));
      if (localObject == null)
        continue;
      localText.setText(localObject.toString());
    }
    getShell().setCursor(null);
    return localComposite1;
  }

  protected void okPressed()
  {
    for (int i = 0; i < this.c.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.c.get(i);
      if (this.b.get(localMethodParam) == null)
        this.d.add(null);
      Object localObject;
      if ((this.b.get(localMethodParam) instanceof Combo))
      {
        localObject = (Combo)this.b.get(localMethodParam);
        if (((Combo)localObject).getText().length() > 0)
          this.d.add(this.a.getTypeManager().a(localMethodParam.getTypeName()).f(((Combo)localObject).getText()));
        this.a.getOldInputs().put(String.valueOf(i), ((Combo)localObject).getText());
      }
      else
      {
        if (!(this.b.get(localMethodParam) instanceof Text))
          continue;
        localObject = (Text)this.b.get(localMethodParam);
        if (((Text)localObject).getText().length() > 0)
          this.d.add(this.a.getTypeManager().a(localMethodParam.getTypeName()).f(((Text)localObject).getText()));
        this.a.getOldInputs().put(String.valueOf(i), ((Text)localObject).getText());
      }
    }
    super.okPressed();
  }

  public Object[] a()
  {
    Object[] arrayOfObject = new Object[this.d.size()];
    for (int i = 0; i < this.d.size(); i++)
      arrayOfObject[i] = this.d.get(i);
    return this.a.getSelectParams(arrayOfObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.I
 * JD-Core Version:    0.6.0
 */