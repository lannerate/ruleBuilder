package com.flagleader.builder.dialogs.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.f;
import com.flagleader.manager.a.a.c;
import com.flagleader.manager.r;
import com.flagleader.repository.export.IPage;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class p extends f
{
  private IPage a = null;
  private Combo b;
  private String c = "";
  private List d = null;
  private Text e;
  private Text f;
  private Text g;
  private BuilderManager h;
  private int i = -1;

  public p(BuilderManager paramBuilderManager, IPage paramIPage)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramIPage;
    this.h = paramBuilderManager;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    c("title.ExportPageDialog");
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(380, 100));
    this.b = b(localComposite2, "selectLanmu.ExportPageDialog", 12, 270, 18, 2);
    try
    {
      this.d = this.h.getRulesManager().p().b();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getMessage());
      return localComposite1;
    }
    if (this.d != null)
    {
      String[] arrayOfString = new String[this.d.size()];
      for (int j = 0; j < arrayOfString.length; j++)
        arrayOfString[j] = this.d.get(j).toString();
      this.b.setItems(arrayOfString);
      if (this.b.getItemCount() < 20)
        this.b.setVisibleItemCount(this.b.getItemCount());
      else
        this.b.setVisibleItemCount(20);
      this.b.addSelectionListener(new q(this));
    }
    a(localComposite2).setText(b("disName.ExportPageDialog") + ":  ");
    this.e = b(localComposite2, 2048, 280, 12);
    this.e.setText(this.a.getTitle());
    a(localComposite2).setText(b("url.ExportPageDialog") + ":  ");
    this.f = b(localComposite2, 2048, 280, 12);
    this.f.setText(this.a.getDisplayName());
    a(localComposite2).setText(b("resource.ExportPageDialog") + ":  ");
    this.g = b(localComposite2, 2048, 280, 12);
    this.g.setText(this.a.getPropertyValue("judgecode"));
    return localComposite1;
  }

  protected void okPressed()
  {
    if ((this.d == null) || (this.i < 0))
    {
      MessageDialog.openError(getShell(), "", b("needLamu.ExportPageDialog"));
      return;
    }
    if ((this.e.getText() == null) || (this.e.getText().length() == 0))
    {
      MessageDialog.openError(getShell(), "", b("needDiaName.ExportPageDialog"));
      return;
    }
    if ((this.f.getText() == null) || (this.f.getText().length() == 0))
    {
      MessageDialog.openError(getShell(), "", b("needurl.ExportPageDialog"));
      return;
    }
    try
    {
      String str = this.h.getRulesManager().p().a(this.e.getText(), this.f.getText(), ((List)this.d.get(this.i)).get(0), this.g.getText(), this.a.getExportStr());
      if ((str != null) && (str.length() > 0))
        MessageDialog.openError(getShell(), "", str);
      else
        MessageDialog.openInformation(getShell(), "", b("success.ExportPageDialog"));
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getMessage());
      return;
    }
    this.c = this.b.getText();
    super.okPressed();
  }

  public String a()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.p
 * JD-Core Version:    0.6.0
 */