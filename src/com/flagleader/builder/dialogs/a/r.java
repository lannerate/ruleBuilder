package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.MethodParam;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class r extends f
{
  private HashMap a = new HashMap();
  private IFunctionObject b = null;
  private List c = null;

  public r(IFunctionObject paramIFunctionObject)
  {
    super(Display.getCurrent().getActiveShell());
    this.b = paramIFunctionObject;
    this.c = paramIFunctionObject.getParams();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(this.b.getValueName());
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(350, this.c.size() * 22 + 30));
    getShell().setCursor(getShell().getDisplay().getSystemCursor(1));
    for (int i = 0; i < this.c.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.c.get(i);
      a(localComposite2).setText(localMethodParam.getParamName() + ":  ");
      Text localText = super.b(localComposite2, 2048, 260, 15);
      localText.setText(localMethodParam.getDefaultValue());
      this.a.put(localMethodParam, localText);
    }
    getShell().setCursor(null);
    return localComposite1;
  }

  protected void okPressed()
  {
    for (int i = 0; i < this.c.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.c.get(i);
      if ((this.a.get(localMethodParam) == null) || (!(this.a.get(localMethodParam) instanceof Text)))
        continue;
      Text localText = (Text)this.a.get(localMethodParam);
      if (localText.getText().length() <= 0)
        continue;
      localMethodParam.setDefaultValue(localText.getText());
      this.b.changeParams();
    }
    super.okPressed();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.r
 * JD-Core Version:    0.6.0
 */