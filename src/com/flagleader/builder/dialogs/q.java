package com.flagleader.builder.dialogs;

import com.flagleader.builder.a.br;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class q extends g
{
  ProgressBar a = null;
  private br b;

  public q(br parambr)
  {
    super(new Shell());
    this.b = parambr;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    this.a = new ProgressBar(localComposite, 2);
    a(this.a);
    return localComposite;
  }

  protected void createButtonsForButtonBar(Composite paramComposite)
  {
    createButton(paramComposite, 1, b("Cancel"), true);
  }

  protected void cancelPressed()
  {
    this.b.a(true);
    super.cancelPressed();
  }

  private void a(ProgressBar paramProgressBar)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = 250;
    paramProgressBar.setLayoutData(localGridData);
  }

  public boolean close()
  {
    this.b.a(true);
    return super.close();
  }

  public ProgressBar a()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.q
 * JD-Core Version:    0.6.0
 */